public enum Speed
{ 
        STOP(0, 0),
        HALF(100, 100),
        HALF_REVERSE(-100, -100),
        MAX(200, 200),
        MAX_REVERSE(-200, -200),
        LEFT(200, -200),
        RIGHT(-200, 200);
        
        public final int Left, Right;
        
        Speed(int left, int right)
        {
            Left = left;
            Right = right;
        }
}