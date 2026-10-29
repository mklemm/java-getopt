# Publishing to Maven Central

The `release` Maven profile stages the compiled JAR, sources, Javadoc, and POM
in `target/staging-deploy`. JReleaser 1.20.0 then signs and publishes them through
the Central Portal, using the same setup as `kotlin-sourcemodel`.

## Shared credentials

JReleaser automatically reads `~/.jreleaser/config.toml`. Reuse the existing
entries; do not copy secrets into this repository or Maven's POM:

- `JRELEASER_MAVENCENTRAL_USERNAME`
- `JRELEASER_MAVENCENTRAL_PASSWORD`
- `JRELEASER_GPG_PASSPHRASE`

The `sonatype` deployer also accepts the corresponding
`JRELEASER_MAVENCENTRAL_SONATYPE_USERNAME` and
`JRELEASER_MAVENCENTRAL_SONATYPE_PASSWORD` overrides. JReleaser supports supplying
these values through environment variables as well.

Signing uses the existing `~/.gnupg/public.pgp` and `~/.gnupg/private.pgp` files.
The public key must be available to Central's signature verification service.

## Release

The publishing account must have permission to publish the POM's groupId,
currently `gnu.getopt`. Ownership of `net.codesup.util` (used by
`kotlin-sourcemodel`) does not grant access to `gnu.getopt`. If necessary, choose
a groupId under your verified namespace and update consumers accordingly.

1. Set the intended release version in `pom.xml` (for example `1.0.0`). The
   release profile rejects snapshot versions and snapshot dependencies.
2. Build, test, and stage the artifacts locally:

   ```sh
   mvn -Prelease clean deploy
   ```

3. Verify the deployment configuration and run a dry run:

   ```sh
   mvn -Prelease jreleaser:config
   mvn -Prelease jreleaser:deploy -Djreleaser.dry.run=true
   ```

4. Publish the staged release to Maven Central:

   ```sh
   mvn -Prelease jreleaser:deploy
   ```

   This uploads and publishes the release. Published versions cannot be replaced.
   After checking the dry run, you can also build and publish in a single command:

   ```sh
   mvn -Prelease clean deploy jreleaser:deploy
   ```

5. Set the next development version in `pom.xml` with a `-SNAPSHOT` suffix.

Always clean before staging a new release so an older version is not included.
Normal `mvn verify` builds do not activate signing or publishing.
Git tag and GitHub release creation are skipped; this workflow only publishes
Maven artifacts. The generic releaser contains a non-secret placeholder token
to satisfy JReleaser 1.20 validation, and does not use GitHub credentials.

See the [JReleaser Maven Central guide](https://jreleaser.org/guide/latest/examples/maven/maven-central.html)
for the deployment workflow and supported credential sources.
