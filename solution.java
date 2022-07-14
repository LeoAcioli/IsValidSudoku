class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        boolean rows;
        boolean cols;
        boolean squares;
        
        for(int i =0; i<9; i++){
            for(int j=0; j<9; j++){
                sb.append(board[i][j]);     
            }
            for(int x = 0; x<sb.length(); x++){
                int count = 0;
                if (map.get(sb.charAt(x)) != null){
                    count = map.get(sb.charAt(x));
                }
                map.put(sb.charAt(x),count+1);
            }
            
            map.remove('.');
            
            for (Integer value : map.values()){
                if (value>1){return false;}
            }
            map.clear();
            sb.setLength(0);
        }
        rows = true; //rows passed the test
    
        for(int i =0; i<9; i++){
            for(int j=0; j<9; j++){
                sb.append(board[j][i]);     
            }
            for(int x = 0; x<sb.length(); x++){
                int count = 0;
                if (map.get(sb.charAt(x)) != null){
                    count = map.get(sb.charAt(x));
                }
                map.put(sb.charAt(x),count+1);
            }
            map.remove('.');
            for (Integer value : map.values()){
                if (value>1){return false;}
            }
            map.clear();
            sb.setLength(0);
        }
        cols = true; //columns passed the test
        
        for (int row = 0; row<=8;row = row+3){
            for (int col = 0; col <=8; col = col+3){
                sb.append(board[row][col]);
                sb.append(board[row][col+1]);
                sb.append(board[row][col+2]);
                sb.append(board[row+1][col]);
                sb.append(board[row+1][col+1]);
                sb.append(board[row+1][col+2]);
                sb.append(board[row+2][col]);
                sb.append(board[row+2][col+1]);
                sb.append(board[row+2][col+2]);
                
                for(int x = 0; x<sb.length(); x++){
                    int count = 0;
                    if (map.get(sb.charAt(x)) != null){
                        count = map.get(sb.charAt(x));
                    }
                    map.put(sb.charAt(x),count+1);
                }
                map.remove('.');
                
                for (Integer value : map.values()){
                    if (value>1){return false;}
                }
                map.clear();
                sb.setLength(0);
                }
        }
        squares = true;
        if (cols && rows && squares){return true;}
        else{return false;}
    }
}
