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
 * Immutable implementation of {@link Sample.MetadataEntity}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableMetadataEntity.builder()}.
 */
@Generated(from = "Sample.MetadataEntity", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableMetadataEntity implements Sample.MetadataEntity {
  private final Sample.MetadataEntity.Type type;
  private final String value;

  private ImmutableMetadataEntity(Sample.MetadataEntity.Type type, String value) {
    this.type = type;
    this.value = value;
  }

  /**
   * @return The value of the {@code type} attribute
   */
  @JsonProperty(required = true)
  @Override
  public Sample.MetadataEntity.Type getType() {
    return type;
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
   * Copy the current immutable object by setting a value for the {@link Sample.MetadataEntity#getType() type} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableMetadataEntity withType(Sample.MetadataEntity.Type value) {
    if (this.type == value) return this;
    Sample.MetadataEntity.Type newValue = Objects.requireNonNull(value, "type");
    if (this.type.equals(newValue)) return this;
    return new ImmutableMetadataEntity(newValue, this.value);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Sample.MetadataEntity#getValue() value} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for value
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableMetadataEntity withValue(String value) {
    String newValue = Objects.requireNonNull(value, "value");
    if (this.value.equals(newValue)) return this;
    return new ImmutableMetadataEntity(this.type, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableMetadataEntity} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableMetadataEntity
        && equalTo((ImmutableMetadataEntity) another);
  }

  private boolean equalTo(ImmutableMetadataEntity another) {
    return type.equals(another.type)
        && value.equals(another.value);
  }

  /**
   * Computes a hash code from attributes: {@code type}, {@code value}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + type.hashCode();
    h += (h << 5) + value.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code MetadataEntity} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return com.google.common.base.Objects.toStringHelper("MetadataEntity")
        .omitNullValues()
        .add("type", type)
        .add("value", value)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "Sample.MetadataEntity", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements Sample.MetadataEntity {
    @Nullable Sample.MetadataEntity.Type type;
    @Nullable String value;
    @JsonProperty(required = true)
    public void setType(Sample.MetadataEntity.Type type) {
      this.type = type;
    }
    @JsonProperty(required = true)
    public void setValue(String value) {
      this.value = value;
    }
    @Override
    public Sample.MetadataEntity.Type getType() { throw new UnsupportedOperationException(); }
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
  static ImmutableMetadataEntity fromJson(Json json) {
    ImmutableMetadataEntity.Builder builder = ImmutableMetadataEntity.builder();
    if (json.type != null) {
      builder.type(json.type);
    }
    if (json.value != null) {
      builder.value(json.value);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Sample.MetadataEntity} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable MetadataEntity instance
   */
  public static ImmutableMetadataEntity copyOf(Sample.MetadataEntity instance) {
    if (instance instanceof ImmutableMetadataEntity) {
      return (ImmutableMetadataEntity) instance;
    }
    return ImmutableMetadataEntity.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableMetadataEntity ImmutableMetadataEntity}.
   * <pre>
   * ImmutableMetadataEntity.builder()
   *    .type(chattyer.common.models.Sample.MetadataEntity.Type) // required {@link Sample.MetadataEntity#getType() type}
   *    .value(String) // required {@link Sample.MetadataEntity#getValue() value}
   *    .build();
   * </pre>
   * @return A new ImmutableMetadataEntity builder
   */
  public static ImmutableMetadataEntity.Builder builder() {
    return new ImmutableMetadataEntity.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableMetadataEntity ImmutableMetadataEntity}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Sample.MetadataEntity", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_TYPE = 0x1L;
    private static final long INIT_BIT_VALUE = 0x2L;
    private long initBits = 0x3L;

    private @Nullable Sample.MetadataEntity.Type type;
    private @Nullable String value;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code MetadataEntity} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Sample.MetadataEntity instance) {
      Objects.requireNonNull(instance, "instance");
      type(instance.getType());
      value(instance.getValue());
      return this;
    }

    /**
     * Initializes the value for the {@link Sample.MetadataEntity#getType() type} attribute.
     * @param type The value for type 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty(required = true)
    public final Builder type(Sample.MetadataEntity.Type type) {
      this.type = Objects.requireNonNull(type, "type");
      initBits &= ~INIT_BIT_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link Sample.MetadataEntity#getValue() value} attribute.
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
     * Builds a new {@link ImmutableMetadataEntity ImmutableMetadataEntity}.
     * @return An immutable instance of MetadataEntity
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableMetadataEntity build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableMetadataEntity(type, value);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      if ((initBits & INIT_BIT_VALUE) != 0) attributes.add("value");
      return "Cannot build MetadataEntity, some of required attributes are not set " + attributes;
    }
  }
}
