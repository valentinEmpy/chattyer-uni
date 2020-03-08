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
 * Immutable implementation of {@link Intent}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableIntent.builder()}.
 */
@Generated(from = "Intent", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableIntent implements Intent {
  private final String name;

  private ImmutableIntent(String name) {
    this.name = name;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @JsonProperty(required = true)
  @Override
  public String getName() {
    return name;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Intent#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableIntent withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableIntent(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableIntent} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableIntent
        && equalTo((ImmutableIntent) another);
  }

  private boolean equalTo(ImmutableIntent another) {
    return name.equals(another.name);
  }

  /**
   * Computes a hash code from attributes: {@code name}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Intent} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return com.google.common.base.Objects.toStringHelper("Intent")
        .omitNullValues()
        .add("name", name)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "Intent", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements Intent {
    @Nullable String name;
    @JsonProperty(required = true)
    public void setName(String name) {
      this.name = name;
    }
    @Override
    public String getName() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableIntent fromJson(Json json) {
    ImmutableIntent.Builder builder = ImmutableIntent.builder();
    if (json.name != null) {
      builder.name(json.name);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Intent} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Intent instance
   */
  public static ImmutableIntent copyOf(Intent instance) {
    if (instance instanceof ImmutableIntent) {
      return (ImmutableIntent) instance;
    }
    return ImmutableIntent.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableIntent ImmutableIntent}.
   * <pre>
   * ImmutableIntent.builder()
   *    .name(String) // required {@link Intent#getName() name}
   *    .build();
   * </pre>
   * @return A new ImmutableIntent builder
   */
  public static ImmutableIntent.Builder builder() {
    return new ImmutableIntent.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableIntent ImmutableIntent}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Intent", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private long initBits = 0x1L;

    private @Nullable String name;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Intent} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Intent instance) {
      Objects.requireNonNull(instance, "instance");
      name(instance.getName());
      return this;
    }

    /**
     * Initializes the value for the {@link Intent#getName() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty(required = true)
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Builds a new {@link ImmutableIntent ImmutableIntent}.
     * @return An immutable instance of Intent
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableIntent build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableIntent(name);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      return "Cannot build Intent, some of required attributes are not set " + attributes;
    }
  }
}
