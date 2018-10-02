package com.business.benchmarking;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import com.business.logic.BankingSystem;

@State(Scope.Benchmark)
@Measurement(iterations = 4, batchSize = 1)
@Warmup(iterations = 2, batchSize = 1)
@BenchmarkMode({ Mode.Throughput })
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1, warmups = 1)
public class BankingBenchmark {
	private BankingSystem bankingObj;

	@Setup(Level.Invocation)
	public void init() {
		bankingObj = new BankingSystem();
	}

	// input samples of debit amount
	@Param({ "199.8", "500.9", "300", "700.7" })
	private double debitAmt;

	// input samples of cedit amount
	@Param({ "300.8", "100.89", "100", "50.67" })
	private double creditAmt;

	
	@Benchmark
	public void testGetBalance() throws Exception {
		bankingObj.getBalance();
	}

	@Benchmark
	public void testDebitBalance() throws Exception {
		bankingObj.debitBalance(debitAmt);
	}

	@Benchmark
	public void testCreditBalance() throws Exception {
		bankingObj.creditBalance(creditAmt);
	}
}
