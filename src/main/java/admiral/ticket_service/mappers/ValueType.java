package admiral.ticket_service.mappers;

public class ValueType
{
  public static ValueType valueOf(String value)
  {
    return value == null ? null : new ValueType(value);
  }

  private final String value;

  private ValueType(String value)
  {
    this.value = value;
  }

  public String getValue()
  {
    return value;
  }
}
