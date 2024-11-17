package com.thealgorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class AhoCorasick {
    private AhoCorasick() {
    }

    private static class Node {
        
        private final Map<Character, Node> child = new HashMap<>(); 
        private Node suffixLink; 
        private Node outputLink; 
        private int patternInd; 

        Node() {
            this.suffixLink = null;
            this.outputLink = null;
            this.patternInd = -1;
        }

        public Map<Character, Node> getChild() {
            return child;
        }

        public Node getSuffixLink() {
            return suffixLink;
        }

        public void setSuffixLink(final Node suffixLink) {
            this.suffixLink = suffixLink;
        }

        public Node getOutputLink() {
            return outputLink;
        }

        public void setOutputLink(final Node outputLink) {
            this.outputLink = outputLink;
        }

        public int getPatternInd() {
            return patternInd;
        }

        public void setPatternInd(final int patternInd) {
            this.patternInd = patternInd;
        }
    }

    public static class Trie {

        private Node root = null; 
        private final String[] patterns; 

        public Trie(final String[] patterns) {
            root = new Node(); 
            this.patterns = patterns;
            buildTrie();
            buildSuffixAndOutputLinks();
        }

        private void buildTrie() {

            for (int i = 0; i < patterns.length; i++) {
                Node curr = root; 

                for (int j = 0; j < patterns[i].length(); j++) {
                    char c = patterns[i].charAt(j); 

                    if (curr.getChild().containsKey(c)) {
                        curr = curr.getChild().get(c); 
                    } else {
                        
                        Node nn = new Node();
                        curr.getChild().put(c, nn);
                        curr = nn; 
                    }
                }
                curr.setPatternInd(i); 
            }
        }

        private void initializeSuffixLinksForChildNodesOfTheRoot(Queue<Node> q) {
            for (char rc : root.getChild().keySet()) {
                Node childNode = root.getChild().get(rc);
                q.add(childNode); 
                childNode.setSuffixLink(root); 
            }
        }

        private void buildSuffixAndOutputLinks() {
            root.setSuffixLink(root); 
            Queue<Node> q = new LinkedList<>(); 

            initializeSuffixLinksForChildNodesOfTheRoot(q);

            while (!q.isEmpty()) {
                Node currentState = q.poll(); 

                for (char cc : currentState.getChild().keySet()) {
                    Node currentChild = currentState.getChild().get(cc); 
                    Node parentSuffix = currentState.getSuffixLink(); 

                    while (!parentSuffix.getChild().containsKey(cc) && parentSuffix != root) {
                        parentSuffix = parentSuffix.getSuffixLink();
                    }

                    if (parentSuffix.getChild().containsKey(cc)) {
                        currentChild.setSuffixLink(parentSuffix.getChild().get(cc));
                    } else {
                        currentChild.setSuffixLink(root);
                    }

                    q.add(currentChild); 
                }

                if (currentState.getSuffixLink().getPatternInd() >= 0) {
                    currentState.setOutputLink(currentState.getSuffixLink());
                } else {
                    currentState.setOutputLink(currentState.getSuffixLink().getOutputLink());
                }
            }
        }

        private List<List<Integer>> initializePositionByStringIndexValue() {
            List<List<Integer>> positionByStringIndexValue = new ArrayList<>(patterns.length); 
            for (int i = 0; i < patterns.length; i++) {
                positionByStringIndexValue.add(new ArrayList<>());
            }
            return positionByStringIndexValue;
        }

        public List<List<Integer>> searchIn(final String text) {
            var positionByStringIndexValue = initializePositionByStringIndexValue(); 
            Node parent = root; 

            PatternPositionRecorder positionRecorder = new PatternPositionRecorder(positionByStringIndexValue);

            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i); 

                if (parent.getChild().containsKey(ch)) {
                    parent = parent.getChild().get(ch); 
                    positionRecorder.recordPatternPositions(parent, i); 
                } else {
                    
                    while (parent != root && !parent.getChild().containsKey(ch)) {
                        parent = parent.getSuffixLink();
                    }
                    if (parent.getChild().containsKey(ch)) {
                        i--; 
                    }
                }
            }

            setUpStartPoints(positionByStringIndexValue);
            return positionByStringIndexValue;
        }

        private void setUpStartPoints(List<List<Integer>> positionByStringIndexValue) {
            for (int i = 0; i < patterns.length; i++) {
                for (int j = 0; j < positionByStringIndexValue.get(i).size(); j++) {
                    int endpoint = positionByStringIndexValue.get(i).get(j);
                    positionByStringIndexValue.get(i).set(j, endpoint - patterns[i].length() + 1);
                }
            }
        }
    }

    private record PatternPositionRecorder(List<List<Integer>> positionByStringIndexValue) {
        
        public void recordPatternPositions(final Node parent, final int currentPosition) {
            
            if (parent.getPatternInd() > -1) {
                
                positionByStringIndexValue.get(parent.getPatternInd()).add(currentPosition);
            }

            Node outputLink = parent.getOutputLink();
            
            while (outputLink != null) {
                
                positionByStringIndexValue.get(outputLink.getPatternInd()).add(currentPosition);
                outputLink = outputLink.getOutputLink();
            }
        }
    }

    public static Map<String, List<Integer>> search(final String text, final String[] patterns) {
        final var trie = new Trie(patterns);
        final var positionByStringIndexValue = trie.searchIn(text);
        return convert(positionByStringIndexValue, patterns);
    }

    private static Map<String, List<Integer>> convert(final List<List<Integer>> positionByStringIndexValue, final String[] patterns) {
        Map<String, List<Integer>> positionByString = new HashMap<>();
        for (int i = 0; i < patterns.length; i++) {
            String pattern = patterns[i];
            List<Integer> positions = positionByStringIndexValue.get(i);
            positionByString.put(pattern, new ArrayList<>(positions));
        }
        return positionByString;
    }
}
