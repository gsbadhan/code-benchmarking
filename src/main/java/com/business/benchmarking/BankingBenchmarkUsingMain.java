package com.business.benchmarking;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 *  set -server option in VM arguments
 *
 */
public class BankingBenchmarkUsingMain {

	// run benchmark manually
	public static void main(String[] args) throws RunnerException {
		
		Options opt = new OptionsBuilder().include(BankingBenchmark.class.getName()).mode(Mode.Throughput)
				.timeUnit(TimeUnit.MILLISECONDS).warmupIterations(2).measurementIterations(4)
				.threads(Runtime.getRuntime().availableProcessors()).forks(1).warmupForks(1).shouldFailOnError(true)
				.shouldDoGC(true).build();

		new Runner(opt).run();
	}

}
