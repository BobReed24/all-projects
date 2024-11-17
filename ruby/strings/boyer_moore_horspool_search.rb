class BadMatchTable

    attr_reader :pattern
    attr_reader :table

    def initialize(pattern)
        @pattern = pattern
        @table = {}
        for i in 0...pattern.size
            @table[pattern[i]] = pattern.size - 1 - i
        end
    end

    def slide_offset(mismatch_char)
        table.fetch(mismatch_char, pattern.size)
    end
end

def first_match_index(search_string, pattern)
    matches = matches_indices(search_string, pattern, true)
    matches.empty? ? -1 : matches[0]
end

def matches_indices(search_string, pattern, stop_at_first_match=false)
    table = BadMatchTable.new(pattern)
    i = pattern.size - 1
    indices = []
    while i < search_string.size
        for j in 0...pattern.size
            if search_string[i-j] != pattern[pattern.size-1-j]
                i += table.slide_offset(search_string[i-j])
                break
            elsif j == pattern.size-1
                indices.append(i-j)
                return indices if stop_at_first_match
                i += 1
            end
        end
    end
    indices
end
