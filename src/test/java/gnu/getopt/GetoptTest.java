package gnu.getopt;

import org.junit.Test;

public class GetoptTest {

	@Test
	public void testLongopt() {
		final String[] argv = {"--help","--outputdir=/e/full", "--max=theMax", "--o", "nonOpt1", "-bh","-W","maximum=MyArg", "-ccArg", "-b"};

		final int[] outputdirBuffer = new int[1];
		final LongOpt[] longopts = {
				new LongOpt("help", LongOpt.NO_ARGUMENT, null, 'h'),
				new LongOpt("outputdir", LongOpt.REQUIRED_ARGUMENT, outputdirBuffer, 'o'),
				new LongOpt("maximum", LongOpt.OPTIONAL_ARGUMENT, null, 2)
		};
		int c;
		String arg;
		final Getopt g = Getopt.createGnu("testprog", argv, "-:bc::d:hW;", longopts);
		while ((c = g.getopt()) != -1) {
			switch (c) {
				case 0:
					arg = g.getOptarg();
					System.out.println("Got long option with value '" +
							(char)outputdirBuffer[0]
							+ "' with argument " +
							(arg != null ? arg : "null"));
					break;
				//
				case 1:
					System.out.println("I see you have return in order set and that " +
							"a non-option argv element was just found " +
							"with the value '" + g.getOptarg() + "'");
					break;
				//
				case 2:
					arg = g.getOptarg();
					System.out.println("I know this, but pretend I didn't");
					System.out.println("We picked option " +
							longopts[g.getLongind()].getName() +
							" with value " +
							(arg != null ? arg : "null"));
					break;
				//
				case 'b':
					System.out.println("You picked plain old option " + (char)c);
					break;
				//
				case 'c':
				case 'd':
					arg = g.getOptarg();
					System.out.println("You picked option '" + (char)c +
							"' with argument " +
							(arg != null ? arg : "null"));
					break;
				//
				case 'h':
					System.out.println("I see you asked for help");
					break;
				//
				case 'W':
					System.out.println("Hmmm. You tried a -W with an incorrect long " +
							"option name");
					break;
				//
				case ':':
					System.out.println("Doh! You need an argument for option " +
							(char)g.getOptopt());
					break;
				//
				case '?':
					System.out.println("The option '" + (char)g.getOptopt() +
							"' is not valid");
					break;
				//
				default:
					System.out.println("getopt() returned " + c);
					break;
			}
		}
		//
		for (int i = g.getOptind(); i < argv.length; i++) { System.out.println("Non option argv element: " + argv[i] + "\n"); }

	}

	@Test
	public void testMsDos() {
		final String[] argv = {"/HELP","/OUTPUTDIR:/e/full", "/MAX:theMax", "/o", "nonOpt1", "/B", "/CcArgs", "/b"};

		final int[] outputdirBuffer = new int[1];
		final LongOpt[] longopts = {
				new LongOpt("help", LongOpt.NO_ARGUMENT, null, 'h'),
				new LongOpt("outputdir", LongOpt.REQUIRED_ARGUMENT, outputdirBuffer, 'o'),
				new LongOpt("maximum", LongOpt.OPTIONAL_ARGUMENT, null, 2)
		};
		int c;
		String arg;
		final Getopt g = Getopt.createMsDos("testprog", argv, "-:bc::d:hW;", longopts);
		while ((c = g.getopt()) != -1) {
			switch (c) {
				case 0:
					arg = g.getOptarg();
					System.out.println("Got long option with value '" +
							(char)outputdirBuffer[0]
							+ "' with argument " +
							(arg != null ? arg : "null"));
					break;
				//
				case 1:
					System.out.println("I see you have return in order set and that " +
							"a non-option argv element was just found " +
							"with the value '" + g.getOptarg() + "'");
					break;
				//
				case 2:
					arg = g.getOptarg();
					System.out.println("I know this, but pretend I didn't");
					System.out.println("We picked option " +
							longopts[g.getLongind()].getName() +
							" with value " +
							(arg != null ? arg : "null"));
					break;
				//
				case 'b':
					System.out.println("You picked plain old option " + (char)c);
					break;
				//
				case 'c':
				case 'd':
					arg = g.getOptarg();
					System.out.println("You picked option '" + (char)c +
							"' with argument " +
							(arg != null ? arg : "null"));
					break;
				//
				case 'h':
					System.out.println("I see you asked for help");
					break;
				//
				case 'W':
					System.out.println("Hmmm. You tried a -W with an incorrect long " +
							"option name");
					break;
				//
				case ':':
					System.out.println("Doh! You need an argument for option " +
							(char)g.getOptopt());
					break;
				//
				case '?':
					System.out.println("The option '" + (char)g.getOptopt() +
							"' is not valid");
					break;
				//
				default:
					System.out.println("getopt() returned " + c);
					break;
			}
		}
		//
		for (int i = g.getOptind(); i < argv.length; i++) { System.out.println("Non option argv element: " + argv[i] + "\n"); }

	}

	@Test
	public void testMsPowerShell() {
		final String[] argv = {"-Help","-OutputDir=/e/full", "-Max=theMax", "-O", "nonOpt1", "-bh", "-C", "-b"};

		final int[] outputdirBuffer = new int[1];
		final LongOpt[] longopts = {
				new LongOpt("help", LongOpt.NO_ARGUMENT, null, 'h'),
				new LongOpt("outputdir", LongOpt.REQUIRED_ARGUMENT, outputdirBuffer, 'o'),
				new LongOpt("maximum", LongOpt.OPTIONAL_ARGUMENT, null, 2)
		};
		int c;
		String arg;
		final Getopt g = Getopt.createMsPowerShell("testprog", argv, "-:bc::d:hW;", longopts);
		while ((c = g.getopt()) != -1) {
			switch (c) {
				case 0:
					arg = g.getOptarg();
					System.out.println("Got long option with value '" +
							(char)outputdirBuffer[0]
							+ "' with argument " +
							(arg != null ? arg : "null"));
					break;
				//
				case 1:
					System.out.println("I see you have return in order set and that " +
							"a non-option argv element was just found " +
							"with the value '" + g.getOptarg() + "'");
					break;
				//
				case 2:
					arg = g.getOptarg();
					System.out.println("I know this, but pretend I didn't");
					System.out.println("We picked option " +
							longopts[g.getLongind()].getName() +
							" with value " +
							(arg != null ? arg : "null"));
					break;
				//
				case 'b':
					System.out.println("You picked plain old option " + (char)c);
					break;
				//
				case 'c':
				case 'd':
					arg = g.getOptarg();
					System.out.println("You picked option '" + (char)c +
							"' with argument " +
							(arg != null ? arg : "null"));
					break;
				//
				case 'h':
					System.out.println("I see you asked for help");
					break;
				//
				case 'W':
					System.out.println("Hmmm. You tried a -W with an incorrect long " +
							"option name");
					break;
				//
				case ':':
					System.out.println("Doh! You need an argument for option " +
							(char)g.getOptopt());
					break;
				//
				case '?':
					System.out.println("The option '" + (char)g.getOptopt() +
							"' is not valid");
					break;
				//
				default:
					System.out.println("getopt() returned " + c);
					break;
			}
		}
		//
		for (int i = g.getOptind(); i < argv.length; i++) { System.out.println("Non option argv element: " + argv[i] + "\n"); }

	}
}
