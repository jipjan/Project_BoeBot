public enum Speed
{ 
        STOP(0, 0),
        HALF(50, 50),
        HALF_REVERSE(-50, -50),
        MAX(200, 200),
        MAX_REVERSE(-200, -200),
        LEFT(200, -200),
        RIGHT(-200, 200),
        HALF_LEFT_REVERSE(-200, -50),
        HALF_RIGHT_REVERSE(-50, -200),
        HALF_LEFT(200, 50),
        HALF_RIGHT(50, 200),
        LINE_LEFT(100, 0),
        LINE_RIGHT(0, 100);
        
        public int Left, Right;
        
        Speed(int left, int right)
        {
            Left = left;
            Right = right;
        }
        
        public boolean equals(int left, int right)
        {
            return (left == Left && right == Right);
        }
        
        public int compare(int left, int right)
        {
            if (equals(left, right))
                return 0;
            if (left > Left && right > Right)
                return 1;
            else
                return -1;
        }
}