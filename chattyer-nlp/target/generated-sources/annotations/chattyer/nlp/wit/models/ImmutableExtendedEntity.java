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
 * Immutable implementation of {@link ExtendedEntity}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableExtendedEntity.builder()}.
 */
@Generated(from = "ExtendedEntity", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ImmutableExtendedEntity implements ExtendedEntity {
  private final String name;
  private final String lang;
  private final boolean builtIn;
  private final String doc;
  private final String id;
  private final List<ExtendedEntity.Value> values;

  private ImmutableExtendedEntity(ImmutableExtendedEntity.Builder builder) {
    this.name = builder.name;
    this.lang = builder.lang;
    this.builtIn = builder.builtIn;
    this.doc = builder.doc;
    this.id = builder.id;
    this.values = createUnmodifiableList(true, builder.values);
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @JsonProperty("name")
  @Override
  public String getName() {
    return name;
  }

  /**
   * @return The value of the {@code lang} attribute
   */
  @JsonProperty("lang")
  @Override
  public String getLang() {
    return lang;
  }

  /**
   * @return The value of the {@code builtIn} attribute
   */
  @JsonProperty("builtin")
  @Override
  public boolean getBuiltIn() {
    return builtIn;
  }

  /**
   * @return The value of the {@code doc} attribute
   */
  @JsonProperty("doc")
  @Override
  public String getDoc() {
    return doc;
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @JsonProperty("id")
  @Override
  public String getId() {
    return id;
  }

  /**
   * @return The value of the {@code values} attribute
   */
  @JsonProperty("values")
  @Override
  public List<ExtendedEntity.Value> getValues() {
    return values;
  }

  /**
   * This instance is equal to all instances of {@code ImmutableExtendedEntity} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableExtendedEntity
        && equalTo((ImmutableExtendedEntity) another);
  }

  private boolean equalTo(ImmutableExtendedEntity another) {
    return name.equals(another.name)
        && lang.equals(another.lang)
        && builtIn == another.builtIn
        && doc.equals(another.doc)
        && id.equals(another.id)
        && values.equals(another.values);
  }

  /**
   * Computes a hash code from attributes: {@code name}, {@code lang}, {@code builtIn}, {@code doc}, {@code id}, {@code values}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + lang.hashCode();
    h += (h << 5) + Boolean.hashCode(builtIn);
    h += (h << 5) + doc.hashCode();
    h += (h << 5) + id.hashCode();
    h += (h << 5) + values.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ExtendedEntity} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "ExtendedEntity{"
        + "name=" + name
        + ", lang=" + lang
        + ", builtIn=" + builtIn
        + ", doc=" + doc
        + ", id=" + id
        + ", values=" + values
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "ExtendedEntity", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements ExtendedEntity {
    @Nullable String name;
    @Nullable String lang;
    boolean builtIn;
    boolean builtInIsSet;
    @Nullable String doc;
    @Nullable String id;
    @Nullable List<ExtendedEntity.Value> values = Collections.emptyList();
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @JsonProperty("lang")
    public void setLang(String lang) {
      this.lang = lang;
    }
    @JsonProperty("builtin")
    public void setBuiltIn(boolean builtIn) {
      this.builtIn = builtIn;
      this.builtInIsSet = true;
    }
    @JsonProperty("doc")
    public void setDoc(String doc) {
      this.doc = doc;
    }
    @JsonProperty("id")
    public void setId(String id) {
      this.id = id;
    }
    @JsonProperty("values")
    public void setValues(List<ExtendedEntity.Value> values) {
      this.values = values;
    }
    @Override
    public String getName() { throw new UnsupportedOperationException(); }
    @Override
    public String getLang() { throw new UnsupportedOperationException(); }
    @Override
    public boolean getBuiltIn() { throw new UnsupportedOperationException(); }
    @Override
    public String getDoc() { throw new UnsupportedOperationException(); }
    @Override
    public String getId() { throw new UnsupportedOperationException(); }
    @Override
    public List<ExtendedEntity.Value> getValues() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableExtendedEntity fromJson(Json json) {
    ImmutableExtendedEntity.Builder builder = ImmutableExtendedEntity.builder();
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.lang != null) {
      builder.lang(json.lang);
    }
    if (json.builtInIsSet) {
      builder.builtIn(json.builtIn);
    }
    if (json.doc != null) {
      builder.doc(json.doc);
    }
    if (json.id != null) {
      builder.id(json.id);
    }
    if (json.values != null) {
      builder.addAllValues(json.values);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link ImmutableExtendedEntity ImmutableExtendedEntity}.
   * <pre>
   * ImmutableExtendedEntity.builder()
   *    .name(String) // required {@link ExtendedEntity#getName() name}
   *    .lang(String) // required {@link ExtendedEntity#getLang() lang}
   *    .builtIn(boolean) // required {@link ExtendedEntity#getBuiltIn() builtIn}
   *    .doc(String) // required {@link ExtendedEntity#getDoc() doc}
   *    .id(String) // required {@link ExtendedEntity#getId() id}
   *    .value|addAllValues(chattyer.nlp.wit.models.ExtendedEntity.Value) // {@link ExtendedEntity#getValues() values} elements
   *    .build();
   * </pre>
   * @return A new ImmutableExtendedEntity builder
   */
  public static ImmutableExtendedEntity.Builder builder() {
    return new ImmutableExtendedEntity.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableExtendedEntity ImmutableExtendedEntity}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "ExtendedEntity", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_LANG = 0x2L;
    private static final long INIT_BIT_BUILT_IN = 0x4L;
    private static final long INIT_BIT_DOC = 0x8L;
    private static final long INIT_BIT_ID = 0x10L;
    private long initBits = 0x1fL;

    private @Nullable String name;
    private @Nullable String lang;
    private boolean builtIn;
    private @Nullable String doc;
    private @Nullable String id;
    private List<ExtendedEntity.Value> values = new ArrayList<ExtendedEntity.Value>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code chattyer.nlp.wit.models.ExtendedEntity} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ExtendedEntity instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    /**
     * Fill a builder with attribute values from the provided {@code chattyer.nlp.wit.models.Entity} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Entity instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    private void from(Object object) {
      if (object instanceof ExtendedEntity) {
        ExtendedEntity instance = (ExtendedEntity) object;
        doc(instance.getDoc());
        id(instance.getId());
        lang(instance.getLang());
        builtIn(instance.getBuiltIn());
        addAllValues(instance.getValues());
      }
      if (object instanceof Entity) {
        Entity instance = (Entity) object;
        name(instance.getName());
      }
    }

    /**
     * Initializes the value for the {@link ExtendedEntity#getName() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("name")
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link ExtendedEntity#getLang() lang} attribute.
     * @param lang The value for lang 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("lang")
    public final Builder lang(String lang) {
      this.lang = Objects.requireNonNull(lang, "lang");
      initBits &= ~INIT_BIT_LANG;
      return this;
    }

    /**
     * Initializes the value for the {@link ExtendedEntity#getBuiltIn() builtIn} attribute.
     * @param builtIn The value for builtIn 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("builtin")
    public final Builder builtIn(boolean builtIn) {
      this.builtIn = builtIn;
      initBits &= ~INIT_BIT_BUILT_IN;
      return this;
    }

    /**
     * Initializes the value for the {@link ExtendedEntity#getDoc() doc} attribute.
     * @param doc The value for doc 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("doc")
    public final Builder doc(String doc) {
      this.doc = Objects.requireNonNull(doc, "doc");
      initBits &= ~INIT_BIT_DOC;
      return this;
    }

    /**
     * Initializes the value for the {@link ExtendedEntity#getId() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("id")
    public final Builder id(String id) {
      this.id = Objects.requireNonNull(id, "id");
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Adds one element to {@link ExtendedEntity#getValues() values} list.
     * @param element A values element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder value(ExtendedEntity.Value element) {
      this.values.add(Objects.requireNonNull(element, "values element"));
      return this;
    }

    /**
     * Adds elements to {@link ExtendedEntity#getValues() values} list.
     * @param elements An array of values elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder values(ExtendedEntity.Value... elements) {
      for (ExtendedEntity.Value element : elements) {
        this.values.add(Objects.requireNonNull(element, "values element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link ExtendedEntity#getValues() values} list.
     * @param elements An iterable of values elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("values")
    public final Builder values(Iterable<? extends ExtendedEntity.Value> elements) {
      this.values.clear();
      return addAllValues(elements);
    }

    /**
     * Adds elements to {@link ExtendedEntity#getValues() values} list.
     * @param elements An iterable of values elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllValues(Iterable<? extends ExtendedEntity.Value> elements) {
      for (ExtendedEntity.Value element : elements) {
        this.values.add(Objects.requireNonNull(element, "values element"));
      }
      return this;
    }

    /**
     * Builds a new {@link ImmutableExtendedEntity ImmutableExtendedEntity}.
     * @return An immutable instance of ExtendedEntity
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableExtendedEntity build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableExtendedEntity(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_LANG) != 0) attributes.add("lang");
      if ((initBits & INIT_BIT_BUILT_IN) != 0) attributes.add("builtIn");
      if ((initBits & INIT_BIT_DOC) != 0) attributes.add("doc");
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      return "Cannot build ExtendedEntity, some of required attributes are not set " + attributes;
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
