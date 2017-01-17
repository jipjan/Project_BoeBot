public enum PathItem
{
    LEFT('a'), UP('w'), RIGHT('d'), DOWN('s'), REVERSE('r');
    
    public final char Value;
    PathItem(char c)
    {
        Value = c;
    }
}
