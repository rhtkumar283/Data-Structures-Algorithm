class romanToInt {
    public static int precedence(char a){
        switch(a){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
        public static int romanToInt(String s) {
        int sum  = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(i == s.length() - 1){
              sum += precedence(ch);
              return sum;
            }
            if(precedence(ch) >= precedence(s.charAt(i+1)))
                sum += precedence(ch);
            else{
                sum = sum + (precedence(s.charAt(i+1)) - precedence(ch));
                i = i+1;
            }
        }
        return sum;
    }
}
