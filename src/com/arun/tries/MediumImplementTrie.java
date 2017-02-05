package com.arun.tries;

import java.util.HashMap;

public class MediumImplementTrie {

    /** Initialize your data structure here. */
	
	public static void main(String[] args){
		MediumImplementTrie inst = new MediumImplementTrie();
		
		inst.insert("arun");
		inst.insert("aruntej");
		
		assert inst.search("a") == false;
		assert inst.search("arun") == true;
		assert inst.search(null) == false;
		assert inst.startsWith("ar") == true;
		assert inst.search("ap") == false;
	}
	
	
	HashMap<Character,TrieNode> baseMap = null;
    public MediumImplementTrie() {
    	this.baseMap = new HashMap<Character,TrieNode>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	if(word == null)
    		return;
        HashMap<Character,TrieNode> cur = baseMap;
        for(int i = 0; i < word.length(); i++){
        	char c = word.charAt(i);
        	
        	if(!cur.containsKey(c)){
        		cur.put(c, new TrieNode(c));
        	}
        	
        	TrieNode node = cur.get(c);
        	
        	if(i == word.length() - 1){
        		node.isLeaf = true;
        	}else{
        		cur = node.children;
        	}
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	if(word == null)
    		return false;
    	HashMap<Character,TrieNode> cur = baseMap;
        for(int i = 0; i < word.length(); i++){
        	char c = word.charAt(i);
        	
        	if(!cur.containsKey(c)){
        		return false;
        	}
        	
        	TrieNode node = cur.get(c);
        	
        	if(i == word.length() - 1){
        		if(node.isLeaf == true)
        			return true;
        		else
        			return false;
        	}else{
        		cur = node.children;
        	}
        }
    	
    	
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	HashMap<Character,TrieNode> cur = baseMap;
        for(int i = 0; i < prefix.length(); i++){
        	char c = prefix.charAt(i);
        	
        	if(!cur.containsKey(c)){
        		return false;
        	}
        	
        	TrieNode node = cur.get(c);
        	cur = node.children;
        }
        return true;
    }
    
}

class TrieNode{
	char c;
	HashMap<Character,TrieNode> children = null;
	boolean isLeaf = false;
	
	public TrieNode(char c) {
		this.c = c;
		this.children = new HashMap<Character,TrieNode>();
	}
}