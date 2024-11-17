package com.thealgorithms.searches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Movie {
    int docId; 
    String name; 
    double imdbRating; 
    int releaseYear; 
    String content; 

    Movie(int docId, String name, double imdbRating, int releaseYear, String content) {
        this.docId = docId;
        this.name = name;
        this.imdbRating = imdbRating;
        this.releaseYear = releaseYear;
        this.content = content;
    }

    public String[] getWords() {
        return (name + " " + content).toLowerCase().split("\\W+");
    }

    @Override
    public String toString() {
        return "Movie{"
            + "docId=" + docId + ", name='" + name + '\'' + ", imdbRating=" + imdbRating + ", releaseYear=" + releaseYear + '}';
    }
}

class SearchResult {
    int docId; 
    double relevanceScore; 

    SearchResult(int docId, double relevanceScore) {
        this.docId = docId;
        this.relevanceScore = relevanceScore;
    }

    public int getDocId() {
        return docId;
    }

    @Override
    public String toString() {
        return "SearchResult{"
            + "docId=" + docId + ", relevanceScore=" + relevanceScore + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SearchResult that = (SearchResult) o;
        return docId == that.docId && Double.compare(that.relevanceScore, relevanceScore) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(docId, relevanceScore);
    }

    public double getRelevanceScore() {
        return this.relevanceScore;
    }
}

public final class BM25InvertedIndex {
    private Map<String, Map<Integer, Integer>> index; 
    private Map<Integer, Movie> movies; 
    private int totalDocuments; 
    private double avgDocumentLength; 
    private static final double K = 1.5; 
    private static final double B = 0.75; 

    BM25InvertedIndex() {
        index = new HashMap<>();
        movies = new HashMap<>();
        totalDocuments = 0;
        avgDocumentLength = 0.0;
    }

    public void addMovie(int docId, String name, double imdbRating, int releaseYear, String content) {
        Movie movie = new Movie(docId, name, imdbRating, releaseYear, content);
        movies.put(docId, movie);
        totalDocuments++;

        String[] terms = movie.getWords();
        int docLength = terms.length;

        avgDocumentLength = (avgDocumentLength * (totalDocuments - 1) + docLength) / totalDocuments;

        for (String term : terms) {
            
            index.putIfAbsent(term, new HashMap<>());

            Map<Integer, Integer> docList = index.get(term);
            if (docList == null) {
                docList = new HashMap<>();
                index.put(term, docList); 
            }
            
            docList.put(docId, docList.getOrDefault(docId, 0) + 1);
        }
    }

    public int getMoviesLength() {
        return movies.size();
    }

    public List<SearchResult> search(String term) {
        term = term.toLowerCase(); 
        if (!index.containsKey(term)) {
            return new ArrayList<>(); 
        }

        Map<Integer, Integer> termDocs = index.get(term); 
        List<SearchResult> results = new ArrayList<>();

        double idf = computeIDF(termDocs.size());

        for (Map.Entry<Integer, Integer> entry : termDocs.entrySet()) {
            int docId = entry.getKey();
            int termFrequency = entry.getValue();
            Movie movie = movies.get(docId);
            if (movie == null) {
                continue; 
            }
            double docLength = movie.getWords().length;

            double score = computeBM25Score(termFrequency, docLength, idf);
            results.add(new SearchResult(docId, score));
        }

        results.sort((r1, r2) -> Double.compare(r2.relevanceScore, r1.relevanceScore));
        return results;
    }

    private double computeBM25Score(int termFrequency, double docLength, double idf) {
        double numerator = termFrequency * (K + 1);
        double denominator = termFrequency + K * (1 - B + B * (docLength / avgDocumentLength));
        return idf * (numerator / denominator);
    }

    private double computeIDF(int docFrequency) {
        
        return Math.log((totalDocuments - docFrequency + 0.5) / (docFrequency + 0.5) + 1);
    }
}
