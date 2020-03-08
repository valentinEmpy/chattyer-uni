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
 * Immutable implementation of {@link Sample}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableSample.builder()}.
 */
@Generated(from = "Sample", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ImmutableSample implements Sample {
  private final String text;
  private final List<Sample.EntityWithValue> entities;

  private ImmutableSample(ImmutableSample.Builder builder) {
    this.text = builder.text;
    this.entities = createUnmodifiableList(true, builder.entities);
  }

  /**
   * @return The value of the {@code text} attribute
   */
  @JsonProperty("text")
  @Override
  public String getText() {
    return text;
  }

  /**
   * @return The value of the {@code entities} attribute
   */
  @JsonProperty("entities")
  @Override
  public List<Sample.EntityWithValue> getEntities() {
    return entities;
  }

  /**
   * This instance is equal to all instances of {@code ImmutableSample} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableSample
        && equalTo((ImmutableSample) another);
  }

  private boolean equalTo(ImmutableSample another) {
    return text.equals(another.text)
        && entities.equals(another.entities);
  }

  /**
   * Computes a hash code from attributes: {@code text}, {@code entities}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + text.hashCode();
    h += (h << 5) + entities.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Sample} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Sample{"
        + "text=" + text
        + ", entities=" + entities
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "Sample", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements Sample {
    @Nullable String text;
    @Nullable List<Sample.EntityWithValue> entities = Collections.emptyList();
    @JsonProperty("text")
    public void setText(String text) {
      this.text = text;
    }
    @JsonProperty("entities")
    public void setEntities(List<Sample.EntityWithValue> entities) {
      this.entities = entities;
    }
    @Override
    public String getText() { throw new UnsupportedOperationException(); }
    @Override
    public List<Sample.EntityWithValue> getEntities() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableSample fromJson(Json json) {
    ImmutableSample.Builder builder = ImmutableSample.builder();
    if (json.text != null) {
      builder.text(json.text);
    }
    if (json.entities != null) {
      builder.addAllEntities(json.entities);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link ImmutableSample ImmutableSample}.
   * <pre>
   * ImmutableSample.builder()
   *    .text(String) // required {@link Sample#getText() text}
   *    .entity|addAllEntities(chattyer.nlp.wit.models.Sample.EntityWithValue) // {@link Sample#getEntities() entities} elements
   *    .build();
   * </pre>
   * @return A new ImmutableSample builder
   */
  public static ImmutableSample.Builder builder() {
    return new ImmutableSample.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableSample ImmutableSample}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Sample", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_TEXT = 0x1L;
    private long initBits = 0x1L;

    private @Nullable String text;
    private List<Sample.EntityWithValue> entities = new ArrayList<Sample.EntityWithValue>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Sample} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Sample instance) {
      Objects.requireNonNull(instance, "instance");
      text(instance.getText());
      addAllEntities(instance.getEntities());
      return this;
    }

    /**
     * Initializes the value for the {@link Sample#getText() text} attribute.
     * @param text The value for text 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("text")
    public final Builder text(String text) {
      this.text = Objects.requireNonNull(text, "text");
      initBits &= ~INIT_BIT_TEXT;
      return this;
    }

    /**
     * Adds one element to {@link Sample#getEntities() entities} list.
     * @param element A entities element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entity(Sample.EntityWithValue element) {
      this.entities.add(Objects.requireNonNull(element, "entities element"));
      return this;
    }

    /**
     * Adds elements to {@link Sample#getEntities() entities} list.
     * @param elements An array of entities elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entities(Sample.EntityWithValue... elements) {
      for (Sample.EntityWithValue element : elements) {
        this.entities.add(Objects.requireNonNull(element, "entities element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link Sample#getEntities() entities} list.
     * @param elements An iterable of entities elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("entities")
    public final Builder entities(Iterable<? extends Sample.EntityWithValue> elements) {
      this.entities.clear();
      return addAllEntities(elements);
    }

    /**
     * Adds elements to {@link Sample#getEntities() entities} list.
     * @param elements An iterable of entities elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllEntities(Iterable<? extends Sample.EntityWithValue> elements) {
      for (Sample.EntityWithValue element : elements) {
        this.entities.add(Objects.requireNonNull(element, "entities element"));
      }
      return this;
    }

    /**
     * Builds a new {@link ImmutableSample ImmutableSample}.
     * @return An immutable instance of Sample
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableSample build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableSample(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_TEXT) != 0) attributes.add("text");
      return "Cannot build Sample, some of required attributes are not set " + attributes;
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
