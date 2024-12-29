package com.javablocks;

import java.util.ArrayList;
import java.util.List;

// Define a basic blockchain structure
class Blockchain {
    private List<Block> chain;

    // Constructor to initialize blockchain with a genesis block
    public Blockchain() {
        setChain(new ArrayList<>());
        // Add a genesis block
        getChain().add(new Block(0, "0", "Genesis Block"));
    }

    // Get the latest block in the blockchain
    public Block getLatestBlock() {
        return getChain().get(getChain().size() - 1);
    }

    // Add a new block to the blockchain
    public void addBlock(Block newBlock) {
        newBlock.setPreviousHash(getLatestBlock().getHash());
        newBlock.setHash(newBlock.calculateHash());
        getChain().add(newBlock);
    }

    // Validate the blockchain by checking hashes and previous hashes
    public boolean isChainValid() {
        for (int i = 1; i < getChain().size(); i++) {
            Block currentBlock = getChain().get(i);
            Block previousBlock = getChain().get(i - 1);

            // Check if hashes are equal
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }

            // Check if previousHashes are equal
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }

	public void setChain(List<Block> chain) {
		this.chain = chain;
	}

	public List<Block> getChain() {
		return chain;
	}
}