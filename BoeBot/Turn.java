public enum Turn
{ 
        LEFT(200, -200),
        RIGHT(-200, 200);
        
        public final int Left, Right;
        
        Turn(int left, int right)
        {
            Left = left;
            Right = right;
        }
}