package com.javablocks;




class Block {
    private int index;
    private String previousHash;
    private String data;
    private String hash;

    // Constructor
    public Block(int index, String previousHash, String data) {
        this.index = index;
        this.setPreviousHash(previousHash);
        this.data = data;
        this.setHash(calculateHash());
    }

    // Calculate block hash based on index, previousHash, and data
    public String calculateHash() {
        return StringUtil.applySha256(
                previousHash +
                Integer.toString(index) +
                data
        );
    }

    // Getters and Setters
    public int getIndex() {
        return index;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public String getHash() {
        return hash;
    }

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
    
    
    
}