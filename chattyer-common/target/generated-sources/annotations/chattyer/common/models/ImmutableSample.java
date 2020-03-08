package chattyer.common.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
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
public final class ImmutableSample implements Sample {
  private final String text;
  private final String intent;
  private final ImmutableList<Sample.MetadataEntity> metadata;

  private ImmutableSample(
      String text,
      String intent,
      ImmutableList<Sample.MetadataEntity> metadata) {
    this.text = text;
    this.intent = intent;
    this.metadata = metadata;
  }

  /**
   * @return The value of the {@code text} attribute
   */
  @JsonProperty(required = true)
  @Override
  public String getText() {
    return text;
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
   * @return The value of the {@code metadata} attribute
   */
  @JsonProperty("metadata")
  @Override
  public ImmutableList<Sample.MetadataEntity> getMetadata() {
    return metadata;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Sample#getText() text} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for text
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSample withText(String value) {
    String newValue = Objects.requireNonNull(value, "text");
    if (this.text.equals(newValue)) return this;
    return new ImmutableSample(newValue, this.intent, this.metadata);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Sample#getIntent() intent} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for intent
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSample withIntent(String value) {
    String newValue = Objects.requireNonNull(value, "intent");
    if (this.intent.equals(newValue)) return this;
    return new ImmutableSample(this.text, newValue, this.metadata);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Sample#getMetadata() metadata}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableSample withMetadata(Sample.MetadataEntity... elements) {
    ImmutableList<Sample.MetadataEntity> newValue = ImmutableList.copyOf(elements);
    return new ImmutableSample(this.text, this.intent, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Sample#getMetadata() metadata}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of metadata elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableSample withMetadata(Iterable<? extends Sample.MetadataEntity> elements) {
    if (this.metadata == elements) return this;
    ImmutableList<Sample.MetadataEntity> newValue = ImmutableList.copyOf(elements);
    return new ImmutableSample(this.text, this.intent, newValue);
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
        && intent.equals(another.intent)
        && metadata.equals(another.metadata);
  }

  /**
   * Computes a hash code from attributes: {@code text}, {@code intent}, {@code metadata}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + text.hashCode();
    h += (h << 5) + intent.hashCode();
    h += (h << 5) + metadata.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Sample} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return com.google.common.base.Objects.toStringHelper("Sample")
        .omitNullValues()
        .add("text", text)
        .add("intent", intent)
        .add("metadata", metadata)
        .toString();
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
    @Nullable String intent;
    @Nullable List<Sample.MetadataEntity> metadata = ImmutableList.of();
    @JsonProperty(required = true)
    public void setText(String text) {
      this.text = text;
    }
    @JsonProperty(required = true)
    public void setIntent(String intent) {
      this.intent = intent;
    }
    @JsonProperty("metadata")
    public void setMetadata(List<Sample.MetadataEntity> metadata) {
      this.metadata = metadata;
    }
    @Override
    public String getText() { throw new UnsupportedOperationException(); }
    @Override
    public String getIntent() { throw new UnsupportedOperationException(); }
    @Override
    public List<Sample.MetadataEntity> getMetadata() { throw new UnsupportedOperationException(); }
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
    if (json.intent != null) {
      builder.intent(json.intent);
    }
    if (json.metadata != null) {
      builder.addAllMetadata(json.metadata);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Sample} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Sample instance
   */
  public static ImmutableSample copyOf(Sample instance) {
    if (instance instanceof ImmutableSample) {
      return (ImmutableSample) instance;
    }
    return ImmutableSample.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableSample ImmutableSample}.
   * <pre>
   * ImmutableSample.builder()
   *    .text(String) // required {@link Sample#getText() text}
   *    .intent(String) // required {@link Sample#getIntent() intent}
   *    .addMetadata|addAllMetadata(chattyer.common.models.Sample.MetadataEntity) // {@link Sample#getMetadata() metadata} elements
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
    private static final long INIT_BIT_INTENT = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String text;
    private @Nullable String intent;
    private ImmutableList.Builder<Sample.MetadataEntity> metadata = ImmutableList.builder();

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
      intent(instance.getIntent());
      addAllMetadata(instance.getMetadata());
      return this;
    }

    /**
     * Initializes the value for the {@link Sample#getText() text} attribute.
     * @param text The value for text 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty(required = true)
    public final Builder text(String text) {
      this.text = Objects.requireNonNull(text, "text");
      initBits &= ~INIT_BIT_TEXT;
      return this;
    }

    /**
     * Initializes the value for the {@link Sample#getIntent() intent} attribute.
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
     * Adds one element to {@link Sample#getMetadata() metadata} list.
     * @param element A metadata element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addMetadata(Sample.MetadataEntity element) {
      this.metadata.add(element);
      return this;
    }

    /**
     * Adds elements to {@link Sample#getMetadata() metadata} list.
     * @param elements An array of metadata elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addMetadata(Sample.MetadataEntity... elements) {
      this.metadata.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link Sample#getMetadata() metadata} list.
     * @param elements An iterable of metadata elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("metadata")
    public final Builder metadata(Iterable<? extends Sample.MetadataEntity> elements) {
      this.metadata = ImmutableList.builder();
      return addAllMetadata(elements);
    }

    /**
     * Adds elements to {@link Sample#getMetadata() metadata} list.
     * @param elements An iterable of metadata elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllMetadata(Iterable<? extends Sample.MetadataEntity> elements) {
      this.metadata.addAll(elements);
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
      return new ImmutableSample(text, intent, metadata.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_TEXT) != 0) attributes.add("text");
      if ((initBits & INIT_BIT_INTENT) != 0) attributes.add("intent");
      return "Cannot build Sample, some of required attributes are not set " + attributes;
    }
  }
}
