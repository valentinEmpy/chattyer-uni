package chattyer.nlp.wit.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link AnalysedMessage.EntityValue}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableEntityValue.builder()}.
 */
@Generated(from = "AnalysedMessage.EntityValue", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ImmutableEntityValue implements AnalysedMessage.EntityValue {
  private final Double confidence;
  private final String value;
  private final @Nullable String type;

  private ImmutableEntityValue(ImmutableEntityValue.Builder builder) {
    this.confidence = builder.confidence;
    this.value = builder.value;
    this.type = builder.type;
  }

  /**
   * @return The value of the {@code confidence} attribute
   */
  @JsonProperty("confidence")
  @Override
  public Double getConfidence() {
    return confidence;
  }

  /**
   * @return The value of the {@code value} attribute
   */
  @JsonProperty("value")
  @Override
  public String getValue() {
    return value;
  }

  /**
   * @return The value of the {@code type} attribute
   */
  @JsonProperty("type")
  @Override
  public @Nullable String getType() {
    return type;
  }

  /**
   * This instance is equal to all instances of {@code ImmutableEntityValue} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@javax.annotation.Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableEntityValue
        && equalTo((ImmutableEntityValue) another);
  }

  private boolean equalTo(ImmutableEntityValue another) {
    return confidence.equals(another.confidence)
        && value.equals(another.value)
        && Objects.equals(type, another.type);
  }

  /**
   * Computes a hash code from attributes: {@code confidence}, {@code value}, {@code type}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + confidence.hashCode();
    h += (h << 5) + value.hashCode();
    h += (h << 5) + Objects.hashCode(type);
    return h;
  }

  /**
   * Prints the immutable value {@code EntityValue} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "EntityValue{"
        + "confidence=" + confidence
        + ", value=" + value
        + ", type=" + type
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "AnalysedMessage.EntityValue", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements AnalysedMessage.EntityValue {
    @javax.annotation.Nullable Double confidence;
    @javax.annotation.Nullable String value;
    @javax.annotation.Nullable String type;
    @JsonProperty("confidence")
    public void setConfidence(Double confidence) {
      this.confidence = confidence;
    }
    @JsonProperty("value")
    public void setValue(String value) {
      this.value = value;
    }
    @JsonProperty("type")
    public void setType(@Nullable String type) {
      this.type = type;
    }
    @Override
    public Double getConfidence() { throw new UnsupportedOperationException(); }
    @Override
    public String getValue() { throw new UnsupportedOperationException(); }
    @Override
    public String getType() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableEntityValue fromJson(Json json) {
    ImmutableEntityValue.Builder builder = ImmutableEntityValue.builder();
    if (json.confidence != null) {
      builder.confidence(json.confidence);
    }
    if (json.value != null) {
      builder.value(json.value);
    }
    if (json.type != null) {
      builder.type(json.type);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link ImmutableEntityValue ImmutableEntityValue}.
   * <pre>
   * ImmutableEntityValue.builder()
   *    .confidence(Double) // required {@link AnalysedMessage.EntityValue#getConfidence() confidence}
   *    .value(String) // required {@link AnalysedMessage.EntityValue#getValue() value}
   *    .type(String | null) // nullable {@link AnalysedMessage.EntityValue#getType() type}
   *    .build();
   * </pre>
   * @return A new ImmutableEntityValue builder
   */
  public static ImmutableEntityValue.Builder builder() {
    return new ImmutableEntityValue.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableEntityValue ImmutableEntityValue}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "AnalysedMessage.EntityValue", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CONFIDENCE = 0x1L;
    private static final long INIT_BIT_VALUE = 0x2L;
    private long initBits = 0x3L;

    private @javax.annotation.Nullable Double confidence;
    private @javax.annotation.Nullable String value;
    private @javax.annotation.Nullable String type;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code EntityValue} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(AnalysedMessage.EntityValue instance) {
      Objects.requireNonNull(instance, "instance");
      confidence(instance.getConfidence());
      value(instance.getValue());
      @Nullable String typeValue = instance.getType();
      if (typeValue != null) {
        type(typeValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link AnalysedMessage.EntityValue#getConfidence() confidence} attribute.
     * @param confidence The value for confidence 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("confidence")
    public final Builder confidence(Double confidence) {
      this.confidence = Objects.requireNonNull(confidence, "confidence");
      initBits &= ~INIT_BIT_CONFIDENCE;
      return this;
    }

    /**
     * Initializes the value for the {@link AnalysedMessage.EntityValue#getValue() value} attribute.
     * @param value The value for value 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("value")
    public final Builder value(String value) {
      this.value = Objects.requireNonNull(value, "value");
      initBits &= ~INIT_BIT_VALUE;
      return this;
    }

    /**
     * Initializes the value for the {@link AnalysedMessage.EntityValue#getType() type} attribute.
     * @param type The value for type (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("type")
    public final Builder type(@Nullable String type) {
      this.type = type;
      return this;
    }

    /**
     * Builds a new {@link ImmutableEntityValue ImmutableEntityValue}.
     * @return An immutable instance of EntityValue
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableEntityValue build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableEntityValue(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_CONFIDENCE) != 0) attributes.add("confidence");
      if ((initBits & INIT_BIT_VALUE) != 0) attributes.add("value");
      return "Cannot build EntityValue, some of required attributes are not set " + attributes;
    }
  }
}
