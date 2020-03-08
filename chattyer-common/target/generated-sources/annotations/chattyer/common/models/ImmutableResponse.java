package chattyer.common.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Response}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableResponse.builder()}.
 */
@Generated(from = "Response", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableResponse implements Response {
  private final Response.Type type;
  private final String intent;
  private final String value;

  private ImmutableResponse(Response.Type type, String intent, String value) {
    this.type = type;
    this.intent = intent;
    this.value = value;
  }

  /**
   * @return The value of the {@code type} attribute
   */
  @JsonProperty(required = true)
  @Override
  public Response.Type getType() {
    return type;
  }

  /**
   * @return The value of the {@code intent} attribute
   */
  @JsonProperty(required = true)
  @Override
  public String getIntent() {
    return intent;
  }

  /**
   * @return The value of the {@code value} attribute
   */
  @JsonProperty(required = true)
  @Override
  public String getValue() {
    return value;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Response#getType() type} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableResponse withType(Response.Type value) {
    if (this.type == value) return this;
    Response.Type newValue = Objects.requireNonNull(value, "type");
    if (this.type.equals(newValue)) return this;
    return new ImmutableResponse(newValue, this.intent, this.value);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Response#getIntent() intent} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for intent
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableResponse withIntent(String value) {
    String newValue = Objects.requireNonNull(value, "intent");
    if (this.intent.equals(newValue)) return this;
    return new ImmutableResponse(this.type, newValue, this.value);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Response#getValue() value} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for value
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableResponse withValue(String value) {
    String newValue = Objects.requireNonNull(value, "value");
    if (this.value.equals(newValue)) return this;
    return new ImmutableResponse(this.type, this.intent, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableResponse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableResponse
        && equalTo((ImmutableResponse) another);
  }

  private boolean equalTo(ImmutableResponse another) {
    return type.equals(another.type)
        && intent.equals(another.intent)
        && value.equals(another.value);
  }

  /**
   * Computes a hash code from attributes: {@code type}, {@code intent}, {@code value}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + type.hashCode();
    h += (h << 5) + intent.hashCode();
    h += (h << 5) + value.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Response} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return com.google.common.base.Objects.toStringHelper("Response")
        .omitNullValues()
        .add("type", type)
        .add("intent", intent)
        .add("value", value)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "Response", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements Response {
    @Nullable Response.Type type;
    @Nullable String intent;
    @Nullable String value;
    @JsonProperty(required = true)
    public void setType(Response.Type type) {
      this.type = type;
    }
    @JsonProperty(required = true)
    public void setIntent(String intent) {
      this.intent = intent;
    }
    @JsonProperty(required = true)
    public void setValue(String value) {
      this.value = value;
    }
    @Override
    public Response.Type getType() { throw new UnsupportedOperationException(); }
    @Override
    public String getIntent() { throw new UnsupportedOperationException(); }
    @Override
    public String getValue() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableResponse fromJson(Json json) {
    ImmutableResponse.Builder builder = ImmutableResponse.builder();
    if (json.type != null) {
      builder.type(json.type);
    }
    if (json.intent != null) {
      builder.intent(json.intent);
    }
    if (json.value != null) {
      builder.value(json.value);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Response} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Response instance
   */
  public static ImmutableResponse copyOf(Response instance) {
    if (instance instanceof ImmutableResponse) {
      return (ImmutableResponse) instance;
    }
    return ImmutableResponse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableResponse ImmutableResponse}.
   * <pre>
   * ImmutableResponse.builder()
   *    .type(chattyer.common.models.Response.Type) // required {@link Response#getType() type}
   *    .intent(String) // required {@link Response#getIntent() intent}
   *    .value(String) // required {@link Response#getValue() value}
   *    .build();
   * </pre>
   * @return A new ImmutableResponse builder
   */
  public static ImmutableResponse.Builder builder() {
    return new ImmutableResponse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableResponse ImmutableResponse}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Response", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_TYPE = 0x1L;
    private static final long INIT_BIT_INTENT = 0x2L;
    private static final long INIT_BIT_VALUE = 0x4L;
    private long initBits = 0x7L;

    private @Nullable Response.Type type;
    private @Nullable String intent;
    private @Nullable String value;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Response} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Response instance) {
      Objects.requireNonNull(instance, "instance");
      type(instance.getType());
      intent(instance.getIntent());
      value(instance.getValue());
      return this;
    }

    /**
     * Initializes the value for the {@link Response#getType() type} attribute.
     * @param type The value for type 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty(required = true)
    public final Builder type(Response.Type type) {
      this.type = Objects.requireNonNull(type, "type");
      initBits &= ~INIT_BIT_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link Response#getIntent() intent} attribute.
     * @param intent The value for intent 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty(required = true)
    public final Builder intent(String intent) {
      this.intent = Objects.requireNonNull(intent, "intent");
      initBits &= ~INIT_BIT_INTENT;
      return this;
    }

    /**
     * Initializes the value for the {@link Response#getValue() value} attribute.
     * @param value The value for value 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty(required = true)
    public final Builder value(String value) {
      this.value = Objects.requireNonNull(value, "value");
      initBits &= ~INIT_BIT_VALUE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableResponse ImmutableResponse}.
     * @return An immutable instance of Response
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableResponse build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableResponse(type, intent, value);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      if ((initBits & INIT_BIT_INTENT) != 0) attributes.add("intent");
      if ((initBits & INIT_BIT_VALUE) != 0) attributes.add("value");
      return "Cannot build Response, some of required attributes are not set " + attributes;
    }
  }
}
