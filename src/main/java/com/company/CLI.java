package com.company;

import org.apache.commons.cli.*;

public class CLI {

    public static void main(String[] args) throws ParseException {
        CommandLine cmd = getCommandLine(args);
        if(cmd.hasOption("t")) {
            System.out.printf("%s", cmd.getOptionValue("t"));
        }
        else {
            System.out.printf("%s","ERROR: input not expected");
        }
    }

    private static CommandLine getCommandLine(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("t", true, "display current time");
        CommandLineParser parser = new DefaultParser();
        return parser.parse( options, args);
    }
}
