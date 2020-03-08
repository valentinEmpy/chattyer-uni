package chattyer.nlp.wit.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link ExtendedEntity.Value}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableValue.builder()}.
 */
@Generated(from = "ExtendedEntity.Value", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ImmutableValue implements ExtendedEntity.Value {
  private final String value;
  private final List<String> expressions;

  private ImmutableValue(ImmutableValue.Builder builder) {
    this.value = builder.value;
    this.expressions = createUnmodifiableList(true, builder.expressions);
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
   * @return The value of the {@code expressions} attribute
   */
  @JsonProperty("expressions")
  @Override
  public List<String> getExpressions() {
    return expressions;
  }

  /**
   * This instance is equal to all instances of {@code ImmutableValue} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableValue
        && equalTo((ImmutableValue) another);
  }

  private boolean equalTo(ImmutableValue another) {
    return value.equals(another.value)
        && expressions.equals(another.expressions);
  }

  /**
   * Computes a hash code from attributes: {@code value}, {@code expressions}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + value.hashCode();
    h += (h << 5) + expressions.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Value} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Value{"
        + "value=" + value
        + ", expressions=" + expressions
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "ExtendedEntity.Value", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements ExtendedEntity.Value {
    @Nullable String value;
    @Nullable List<String> expressions = Collections.emptyList();
    @JsonProperty("value")
    public void setValue(String value) {
      this.value = value;
    }
    @JsonProperty("expressions")
    public void setExpressions(List<String> expressions) {
      this.expressions = expressions;
    }
    @Override
    public String getValue() { throw new UnsupportedOperationException(); }
    @Override
    public List<String> getExpressions() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableValue fromJson(Json json) {
    ImmutableValue.Builder builder = ImmutableValue.builder();
    if (json.value != null) {
      builder.value(json.value);
    }
    if (json.expressions != null) {
      builder.addAllExpressions(json.expressions);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link ImmutableValue ImmutableValue}.
   * <pre>
   * ImmutableValue.builder()
   *    .value(String) // required {@link ExtendedEntity.Value#getValue() value}
   *    .expression|addAllExpressions(String) // {@link ExtendedEntity.Value#getExpressions() expressions} elements
   *    .build();
   * </pre>
   * @return A new ImmutableValue builder
   */
  public static ImmutableValue.Builder builder() {
    return new ImmutableValue.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableValue ImmutableValue}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "ExtendedEntity.Value", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_VALUE = 0x1L;
    private long initBits = 0x1L;

    private @Nullable String value;
    private List<String> expressions = new ArrayList<String>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Value} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ExtendedEntity.Value instance) {
      Objects.requireNonNull(instance, "instance");
      value(instance.getValue());
      addAllExpressions(instance.getExpressions());
      return this;
    }

    /**
     * Initializes the value for the {@link ExtendedEntity.Value#getValue() value} attribute.
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
     * Adds one element to {@link ExtendedEntity.Value#getExpressions() expressions} list.
     * @param element A expressions element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder expression(String element) {
      this.expressions.add(Objects.requireNonNull(element, "expressions element"));
      return this;
    }

    /**
     * Adds elements to {@link ExtendedEntity.Value#getExpressions() expressions} list.
     * @param elements An array of expressions elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder expressions(String... elements) {
      for (String element : elements) {
        this.expressions.add(Objects.requireNonNull(element, "expressions element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link ExtendedEntity.Value#getExpressions() expressions} list.
     * @param elements An iterable of expressions elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("expressions")
    public final Builder expressions(Iterable<String> elements) {
      this.expressions.clear();
      return addAllExpressions(elements);
    }

    /**
     * Adds elements to {@link ExtendedEntity.Value#getExpressions() expressions} list.
     * @param elements An iterable of expressions elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllExpressions(Iterable<String> elements) {
      for (String element : elements) {
        this.expressions.add(Objects.requireNonNull(element, "expressions element"));
      }
      return this;
    }

    /**
     * Builds a new {@link ImmutableValue ImmutableValue}.
     * @return An immutable instance of Value
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableValue build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableValue(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_VALUE) != 0) attributes.add("value");
      return "Cannot build Value, some of required attributes are not set " + attributes;
    }
  }

  private static <T> List<T> createSafeList(Iterable<? extends T> iterable, boolean checkNulls, boolean skipNulls) {
    ArrayList<T> list;
    if (iterable instanceof Collection<?>) {
      int size = ((Collection<?>) iterable).size();
      if (size == 0) return Collections.emptyList();
      list = new ArrayList<>();
    } else {
      list = new ArrayList<>();
    }
    for (T element : iterable) {
      if (skipNulls && element == null) continue;
      if (checkNulls) Objects.requireNonNull(element, "element");
      list.add(element);
    }
    return list;
  }

  private static <T> List<T> createUnmodifiableList(boolean clone, List<T> list) {
    switch(list.size()) {
    case 0: return Collections.emptyList();
    case 1: return Collections.singletonList(list.get(0));
    default:
      if (clone) {
        return Collections.unmodifiableList(new ArrayList<>(list));
      } else {
        if (list instanceof ArrayList<?>) {
          ((ArrayList<?>) list).trimToSize();
        }
        return Collections.unmodifiableList(list);
      }
    }
  }
}
