package com.benchmark.harness;

import org.openjdk.jmh.annotations.Benchmark;

public class BankingBenchmark {
	private Banking banking = new Banking();

	@Benchmark
	public void testGetBalance() {
		banking.getBalance();
	}
}
