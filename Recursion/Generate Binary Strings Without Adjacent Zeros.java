/*
    Generate Binary Strings Without Adjacent Zeros
 */



// Approch 1
class Solution {
    public void solve(int idx, String curr, int n, List<String> result){
        if(idx >= n){
            result.add(curr);
            return;
        }

        // take 1
        solve(idx+1, curr+'1', n, result);

        // take 0
        if(idx == 0 || idx > 0 && curr.charAt(idx-1) != '0'){
            solve(idx+1, curr+'0', n, result);
        }
    }
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        
        solve(0, "", n, result);
        return result;
    }
}