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
 * Immutable implementation of {@link ChatbotDescriptor}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableChatbotDescriptor.builder()}.
 */
@Generated(from = "ChatbotDescriptor", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableChatbotDescriptor implements ChatbotDescriptor {
  private final SchemaVersion schemaVersion;
  private final String name;
  private final Language language;
  private final ImmutableList<Intent> intents;
  private final ImmutableList<Sample> samples;
  private final ImmutableList<Response> responses;

  private ImmutableChatbotDescriptor(ImmutableChatbotDescriptor.Builder builder) {
    this.schemaVersion = builder.schemaVersion;
    this.name = builder.name;
    this.intents = builder.intents.build();
    this.samples = builder.samples.build();
    this.responses = builder.responses.build();
    this.language = builder.language != null
        ? builder.language
        : Objects.requireNonNull(ChatbotDescriptor.super.getLanguage(), "language");
  }

  private ImmutableChatbotDescriptor(
      SchemaVersion schemaVersion,
      String name,
      Language language,
      ImmutableList<Intent> intents,
      ImmutableList<Sample> samples,
      ImmutableList<Response> responses) {
    this.schemaVersion = schemaVersion;
    this.name = name;
    this.language = language;
    this.intents = intents;
    this.samples = samples;
    this.responses = responses;
  }

  /**
   * @return The value of the {@code schemaVersion} attribute
   */
  @JsonProperty(value = "schema-version", required = true)
  @Override
  public SchemaVersion getSchemaVersion() {
    return schemaVersion;
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
   * @return The value of the {@code language} attribute
   */
  @JsonProperty("language")
  @Override
  public Language getLanguage() {
    return language;
  }

  /**
   * @return The value of the {@code intents} attribute
   */
  @JsonProperty(required = true)
  @Override
  public ImmutableList<Intent> getIntents() {
    return intents;
  }

  /**
   * @return The value of the {@code samples} attribute
   */
  @JsonProperty(required = true)
  @Override
  public ImmutableList<Sample> getSamples() {
    return samples;
  }

  /**
   * @return The value of the {@code responses} attribute
   */
  @JsonProperty(required = true)
  @Override
  public ImmutableList<Response> getResponses() {
    return responses;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChatbotDescriptor#getSchemaVersion() schemaVersion} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for schemaVersion
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChatbotDescriptor withSchemaVersion(SchemaVersion value) {
    if (this.schemaVersion == value) return this;
    SchemaVersion newValue = Objects.requireNonNull(value, "schemaVersion");
    if (this.schemaVersion.equals(newValue)) return this;
    return new ImmutableChatbotDescriptor(newValue, this.name, this.language, this.intents, this.samples, this.responses);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChatbotDescriptor#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChatbotDescriptor withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableChatbotDescriptor(this.schemaVersion, newValue, this.language, this.intents, this.samples, this.responses);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChatbotDescriptor#getLanguage() language} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for language
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChatbotDescriptor withLanguage(Language value) {
    if (this.language == value) return this;
    Language newValue = Objects.requireNonNull(value, "language");
    if (this.language.equals(newValue)) return this;
    return new ImmutableChatbotDescriptor(this.schemaVersion, this.name, newValue, this.intents, this.samples, this.responses);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ChatbotDescriptor#getIntents() intents}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableChatbotDescriptor withIntents(Intent... elements) {
    ImmutableList<Intent> newValue = ImmutableList.copyOf(elements);
    return new ImmutableChatbotDescriptor(this.schemaVersion, this.name, this.language, newValue, this.samples, this.responses);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ChatbotDescriptor#getIntents() intents}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of intents elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableChatbotDescriptor withIntents(Iterable<? extends Intent> elements) {
    if (this.intents == elements) return this;
    ImmutableList<Intent> newValue = ImmutableList.copyOf(elements);
    return new ImmutableChatbotDescriptor(this.schemaVersion, this.name, this.language, newValue, this.samples, this.responses);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ChatbotDescriptor#getSamples() samples}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableChatbotDescriptor withSamples(Sample... elements) {
    ImmutableList<Sample> newValue = ImmutableList.copyOf(elements);
    return new ImmutableChatbotDescriptor(this.schemaVersion, this.name, this.language, this.intents, newValue, this.responses);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ChatbotDescriptor#getSamples() samples}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of samples elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableChatbotDescriptor withSamples(Iterable<? extends Sample> elements) {
    if (this.samples == elements) return this;
    ImmutableList<Sample> newValue = ImmutableList.copyOf(elements);
    return new ImmutableChatbotDescriptor(this.schemaVersion, this.name, this.language, this.intents, newValue, this.responses);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ChatbotDescriptor#getResponses() responses}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableChatbotDescriptor withResponses(Response... elements) {
    ImmutableList<Response> newValue = ImmutableList.copyOf(elements);
    return new ImmutableChatbotDescriptor(this.schemaVersion, this.name, this.language, this.intents, this.samples, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ChatbotDescriptor#getResponses() responses}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of responses elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableChatbotDescriptor withResponses(Iterable<? extends Response> elements) {
    if (this.responses == elements) return this;
    ImmutableList<Response> newValue = ImmutableList.copyOf(elements);
    return new ImmutableChatbotDescriptor(this.schemaVersion, this.name, this.language, this.intents, this.samples, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableChatbotDescriptor} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableChatbotDescriptor
        && equalTo((ImmutableChatbotDescriptor) another);
  }

  private boolean equalTo(ImmutableChatbotDescriptor another) {
    return schemaVersion.equals(another.schemaVersion)
        && name.equals(another.name)
        && language.equals(another.language)
        && intents.equals(another.intents)
        && samples.equals(another.samples)
        && responses.equals(another.responses);
  }

  /**
   * Computes a hash code from attributes: {@code schemaVersion}, {@code name}, {@code language}, {@code intents}, {@code samples}, {@code responses}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + schemaVersion.hashCode();
    h += (h << 5) + name.hashCode();
    h += (h << 5) + language.hashCode();
    h += (h << 5) + intents.hashCode();
    h += (h << 5) + samples.hashCode();
    h += (h << 5) + responses.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ChatbotDescriptor} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return com.google.common.base.Objects.toStringHelper("ChatbotDescriptor")
        .omitNullValues()
        .add("schemaVersion", schemaVersion)
        .add("name", name)
        .add("language", language)
        .add("intents", intents)
        .add("samples", samples)
        .add("responses", responses)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "ChatbotDescriptor", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements ChatbotDescriptor {
    @Nullable SchemaVersion schemaVersion;
    @Nullable String name;
    @Nullable Language language;
    @Nullable List<Intent> intents = ImmutableList.of();
    @Nullable List<Sample> samples = ImmutableList.of();
    @Nullable List<Response> responses = ImmutableList.of();
    @JsonProperty(value = "schema-version", required = true)
    public void setSchemaVersion(SchemaVersion schemaVersion) {
      this.schemaVersion = schemaVersion;
    }
    @JsonProperty(required = true)
    public void setName(String name) {
      this.name = name;
    }
    @JsonProperty("language")
    public void setLanguage(Language language) {
      this.language = language;
    }
    @JsonProperty(required = true)
    public void setIntents(List<Intent> intents) {
      this.intents = intents;
    }
    @JsonProperty(required = true)
    public void setSamples(List<Sample> samples) {
      this.samples = samples;
    }
    @JsonProperty(required = true)
    public void setResponses(List<Response> responses) {
      this.responses = responses;
    }
    @Override
    public SchemaVersion getSchemaVersion() { throw new UnsupportedOperationException(); }
    @Override
    public String getName() { throw new UnsupportedOperationException(); }
    @Override
    public Language getLanguage() { throw new UnsupportedOperationException(); }
    @Override
    public List<Intent> getIntents() { throw new UnsupportedOperationException(); }
    @Override
    public List<Sample> getSamples() { throw new UnsupportedOperationException(); }
    @Override
    public List<Response> getResponses() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableChatbotDescriptor fromJson(Json json) {
    ImmutableChatbotDescriptor.Builder builder = ImmutableChatbotDescriptor.builder();
    if (json.schemaVersion != null) {
      builder.schemaVersion(json.schemaVersion);
    }
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.language != null) {
      builder.language(json.language);
    }
    if (json.intents != null) {
      builder.addAllIntents(json.intents);
    }
    if (json.samples != null) {
      builder.addAllSamples(json.samples);
    }
    if (json.responses != null) {
      builder.addAllResponses(json.responses);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ChatbotDescriptor} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ChatbotDescriptor instance
   */
  public static ImmutableChatbotDescriptor copyOf(ChatbotDescriptor instance) {
    if (instance instanceof ImmutableChatbotDescriptor) {
      return (ImmutableChatbotDescriptor) instance;
    }
    return ImmutableChatbotDescriptor.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableChatbotDescriptor ImmutableChatbotDescriptor}.
   * <pre>
   * ImmutableChatbotDescriptor.builder()
   *    .schemaVersion(chattyer.common.models.SchemaVersion) // required {@link ChatbotDescriptor#getSchemaVersion() schemaVersion}
   *    .name(String) // required {@link ChatbotDescriptor#getName() name}
   *    .language(chattyer.common.models.Language) // optional {@link ChatbotDescriptor#getLanguage() language}
   *    .addIntents|addAllIntents(chattyer.common.models.Intent) // {@link ChatbotDescriptor#getIntents() intents} elements
   *    .addSamples|addAllSamples(chattyer.common.models.Sample) // {@link ChatbotDescriptor#getSamples() samples} elements
   *    .addResponses|addAllResponses(chattyer.common.models.Response) // {@link ChatbotDescriptor#getResponses() responses} elements
   *    .build();
   * </pre>
   * @return A new ImmutableChatbotDescriptor builder
   */
  public static ImmutableChatbotDescriptor.Builder builder() {
    return new ImmutableChatbotDescriptor.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableChatbotDescriptor ImmutableChatbotDescriptor}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "ChatbotDescriptor", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_SCHEMA_VERSION = 0x1L;
    private static final long INIT_BIT_NAME = 0x2L;
    private long initBits = 0x3L;

    private @Nullable SchemaVersion schemaVersion;
    private @Nullable String name;
    private @Nullable Language language;
    private ImmutableList.Builder<Intent> intents = ImmutableList.builder();
    private ImmutableList.Builder<Sample> samples = ImmutableList.builder();
    private ImmutableList.Builder<Response> responses = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ChatbotDescriptor} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ChatbotDescriptor instance) {
      Objects.requireNonNull(instance, "instance");
      schemaVersion(instance.getSchemaVersion());
      name(instance.getName());
      language(instance.getLanguage());
      addAllIntents(instance.getIntents());
      addAllSamples(instance.getSamples());
      addAllResponses(instance.getResponses());
      return this;
    }

    /**
     * Initializes the value for the {@link ChatbotDescriptor#getSchemaVersion() schemaVersion} attribute.
     * @param schemaVersion The value for schemaVersion 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty(value = "schema-version", required = true)
    public final Builder schemaVersion(SchemaVersion schemaVersion) {
      this.schemaVersion = Objects.requireNonNull(schemaVersion, "schemaVersion");
      initBits &= ~INIT_BIT_SCHEMA_VERSION;
      return this;
    }

    /**
     * Initializes the value for the {@link ChatbotDescriptor#getName() name} attribute.
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
     * Initializes the value for the {@link ChatbotDescriptor#getLanguage() language} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link ChatbotDescriptor#getLanguage() language}.</em>
     * @param language The value for language 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("language")
    public final Builder language(Language language) {
      this.language = Objects.requireNonNull(language, "language");
      return this;
    }

    /**
     * Adds one element to {@link ChatbotDescriptor#getIntents() intents} list.
     * @param element A intents element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addIntents(Intent element) {
      this.intents.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ChatbotDescriptor#getIntents() intents} list.
     * @param elements An array of intents elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addIntents(Intent... elements) {
      this.intents.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link ChatbotDescriptor#getIntents() intents} list.
     * @param elements An iterable of intents elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty(required = true)
    public final Builder intents(Iterable<? extends Intent> elements) {
      this.intents = ImmutableList.builder();
      return addAllIntents(elements);
    }

    /**
     * Adds elements to {@link ChatbotDescriptor#getIntents() intents} list.
     * @param elements An iterable of intents elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllIntents(Iterable<? extends Intent> elements) {
      this.intents.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link ChatbotDescriptor#getSamples() samples} list.
     * @param element A samples element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSamples(Sample element) {
      this.samples.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ChatbotDescriptor#getSamples() samples} list.
     * @param elements An array of samples elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSamples(Sample... elements) {
      this.samples.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link ChatbotDescriptor#getSamples() samples} list.
     * @param elements An iterable of samples elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty(required = true)
    public final Builder samples(Iterable<? extends Sample> elements) {
      this.samples = ImmutableList.builder();
      return addAllSamples(elements);
    }

    /**
     * Adds elements to {@link ChatbotDescriptor#getSamples() samples} list.
     * @param elements An iterable of samples elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllSamples(Iterable<? extends Sample> elements) {
      this.samples.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link ChatbotDescriptor#getResponses() responses} list.
     * @param element A responses element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addResponses(Response element) {
      this.responses.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ChatbotDescriptor#getResponses() responses} list.
     * @param elements An array of responses elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addResponses(Response... elements) {
      this.responses.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link ChatbotDescriptor#getResponses() responses} list.
     * @param elements An iterable of responses elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty(required = true)
    public final Builder responses(Iterable<? extends Response> elements) {
      this.responses = ImmutableList.builder();
      return addAllResponses(elements);
    }

    /**
     * Adds elements to {@link ChatbotDescriptor#getResponses() responses} list.
     * @param elements An iterable of responses elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllResponses(Iterable<? extends Response> elements) {
      this.responses.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableChatbotDescriptor ImmutableChatbotDescriptor}.
     * @return An immutable instance of ChatbotDescriptor
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableChatbotDescriptor build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableChatbotDescriptor(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_SCHEMA_VERSION) != 0) attributes.add("schemaVersion");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      return "Cannot build ChatbotDescriptor, some of required attributes are not set " + attributes;
    }
  }
}
