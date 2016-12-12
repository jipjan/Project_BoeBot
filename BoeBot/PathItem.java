public enum PathItem
{
    LEFT('a'), UP('w'), RIGHT('d');
    
    public final char Value;
    PathItem(char c)
    {
        Value = c;
    }
}
