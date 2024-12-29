package com.javablocks;

// Main class to run the blockchain example
public class Main {
	public static void main(String[] args) {
		// Create a new blockchain
		Blockchain blockchain = new Blockchain();

		
		for (int i = 0; i < 100000; i++) {
			// Add some blocks to the blockchain
			blockchain.addBlock(new Block(i, "", "Transaction Data "+i));
			
		}
		
		

		// Output blockchain contents
		System.out.println("Blockchain valid? " + blockchain.isChainValid());
		System.out.println("Blockchain:");
		for (Block block : blockchain.getChain()) {
			System.out.println("Block #" + block.getIndex() + "\nHash: " + block.getHash() + "\nPrevious Hash: "
					+ block.getPreviousHash() + "\nData: " + block.getData() + "\n");
		}
	}
}
