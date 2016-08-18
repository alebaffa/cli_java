package com.company;

import org.apache.commons.cli.*;

import java.util.Iterator;

public class CLI {

    static Options options;

    public static void main(String[] args) throws ParseException {
        CommandLine cmd = getCommandLine(args);
        Options options = getOptions();
        printUserOptions(cmd, options);

    }

    private static void printUserOptions(CommandLine cmd, Options options) {
        Iterator<Option> iterator = options.getOptions().iterator();
        while (iterator.hasNext()){
            Option option = iterator.next();
            System.out.printf("%s", cmd.getOptionValue(option.getOpt()));
        }
    }

    private static CommandLine getCommandLine(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        return parser.parse(getOptions(), args);
    }

    public CLI(Options options){
        this.options = options;
    }

    private static Options getOptions(){
        return options;
    }
}
