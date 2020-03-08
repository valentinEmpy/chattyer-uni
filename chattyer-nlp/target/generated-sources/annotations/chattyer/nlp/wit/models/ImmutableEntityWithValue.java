package chattyer.nlp.wit.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Sample.EntityWithValue}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableEntityWithValue.builder()}.
 */
@Generated(from = "Sample.EntityWithValue", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ImmutableEntityWithValue implements Sample.EntityWithValue {
  private final Entity entity;
  private final String value;
  private final @Nullable Integer start;
  private final @Nullable Integer end;
  private final List<Sample.EntityWithValue> subEntities;

  private ImmutableEntityWithValue(ImmutableEntityWithValue.Builder builder) {
    this.entity = builder.entity;
    this.value = builder.value;
    this.start = builder.start;
    this.end = builder.end;
    this.subEntities = createUnmodifiableList(true, builder.subEntities);
  }

  /**
   * @return The value of the {@code entity} attribute
   */
  @JsonProperty("entity")
  @JsonIgnore
  @Override
  public Entity getEntity() {
    return entity;
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
   * @return The value of the {@code start} attribute
   */
  @JsonProperty("start")
  @Override
  public @Nullable Integer getStart() {
    return start;
  }

  /**
   * @return The value of the {@code end} attribute
   */
  @JsonProperty("end")
  @Override
  public @Nullable Integer getEnd() {
    return end;
  }

  /**
   * @return The value of the {@code subEntities} attribute
   */
  @JsonProperty("subentities")
  @Override
  public List<Sample.EntityWithValue> getSubEntities() {
    return subEntities;
  }

  /**
   * This instance is equal to all instances of {@code ImmutableEntityWithValue} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@javax.annotation.Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableEntityWithValue
        && equalTo((ImmutableEntityWithValue) another);
  }

  private boolean equalTo(ImmutableEntityWithValue another) {
    return entity.equals(another.entity)
        && value.equals(another.value)
        && Objects.equals(start, another.start)
        && Objects.equals(end, another.end)
        && subEntities.equals(another.subEntities);
  }

  /**
   * Computes a hash code from attributes: {@code entity}, {@code value}, {@code start}, {@code end}, {@code subEntities}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + entity.hashCode();
    h += (h << 5) + value.hashCode();
    h += (h << 5) + Objects.hashCode(start);
    h += (h << 5) + Objects.hashCode(end);
    h += (h << 5) + subEntities.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code EntityWithValue} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "EntityWithValue{"
        + "entity=" + entity
        + ", value=" + value
        + ", start=" + start
        + ", end=" + end
        + ", subEntities=" + subEntities
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "Sample.EntityWithValue", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements Sample.EntityWithValue {
    @javax.annotation.Nullable Entity entity;
    @javax.annotation.Nullable String value;
    @javax.annotation.Nullable Integer start;
    @javax.annotation.Nullable Integer end;
    @javax.annotation.Nullable List<Sample.EntityWithValue> subEntities = Collections.emptyList();
    @JsonProperty("entity")
    @JsonIgnore
    public void setEntity(Entity entity) {
      this.entity = entity;
    }
    @JsonProperty("value")
    public void setValue(String value) {
      this.value = value;
    }
    @JsonProperty("start")
    public void setStart(@Nullable Integer start) {
      this.start = start;
    }
    @JsonProperty("end")
    public void setEnd(@Nullable Integer end) {
      this.end = end;
    }
    @JsonProperty("subentities")
    public void setSubEntities(List<Sample.EntityWithValue> subEntities) {
      this.subEntities = subEntities;
    }
    @Override
    public Entity getEntity() { throw new UnsupportedOperationException(); }
    @Override
    public String getValue() { throw new UnsupportedOperationException(); }
    @Override
    public Integer getStart() { throw new UnsupportedOperationException(); }
    @Override
    public Integer getEnd() { throw new UnsupportedOperationException(); }
    @Override
    public List<Sample.EntityWithValue> getSubEntities() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableEntityWithValue fromJson(Json json) {
    ImmutableEntityWithValue.Builder builder = ImmutableEntityWithValue.builder();
    if (json.entity != null) {
      builder.entity(json.entity);
    }
    if (json.value != null) {
      builder.value(json.value);
    }
    if (json.start != null) {
      builder.start(json.start);
    }
    if (json.end != null) {
      builder.end(json.end);
    }
    if (json.subEntities != null) {
      builder.addAllSubEntities(json.subEntities);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link ImmutableEntityWithValue ImmutableEntityWithValue}.
   * <pre>
   * ImmutableEntityWithValue.builder()
   *    .entity(chattyer.nlp.wit.models.Entity) // required {@link Sample.EntityWithValue#getEntity() entity}
   *    .value(String) // required {@link Sample.EntityWithValue#getValue() value}
   *    .start(Integer | null) // nullable {@link Sample.EntityWithValue#getStart() start}
   *    .end(Integer | null) // nullable {@link Sample.EntityWithValue#getEnd() end}
   *    .subEntity|addAllSubEntities(chattyer.nlp.wit.models.Sample.EntityWithValue) // {@link Sample.EntityWithValue#getSubEntities() subEntities} elements
   *    .build();
   * </pre>
   * @return A new ImmutableEntityWithValue builder
   */
  public static ImmutableEntityWithValue.Builder builder() {
    return new ImmutableEntityWithValue.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableEntityWithValue ImmutableEntityWithValue}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Sample.EntityWithValue", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ENTITY = 0x1L;
    private static final long INIT_BIT_VALUE = 0x2L;
    private long initBits = 0x3L;

    private @javax.annotation.Nullable Entity entity;
    private @javax.annotation.Nullable String value;
    private @javax.annotation.Nullable Integer start;
    private @javax.annotation.Nullable Integer end;
    private List<Sample.EntityWithValue> subEntities = new ArrayList<Sample.EntityWithValue>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code EntityWithValue} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Sample.EntityWithValue instance) {
      Objects.requireNonNull(instance, "instance");
      entity(instance.getEntity());
      value(instance.getValue());
      @Nullable Integer startValue = instance.getStart();
      if (startValue != null) {
        start(startValue);
      }
      @Nullable Integer endValue = instance.getEnd();
      if (endValue != null) {
        end(endValue);
      }
      addAllSubEntities(instance.getSubEntities());
      return this;
    }

    /**
     * Initializes the value for the {@link Sample.EntityWithValue#getEntity() entity} attribute.
     * @param entity The value for entity 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("entity")
    @JsonIgnore
    public final Builder entity(Entity entity) {
      this.entity = Objects.requireNonNull(entity, "entity");
      initBits &= ~INIT_BIT_ENTITY;
      return this;
    }

    /**
     * Initializes the value for the {@link Sample.EntityWithValue#getValue() value} attribute.
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
     * Initializes the value for the {@link Sample.EntityWithValue#getStart() start} attribute.
     * @param start The value for start (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("start")
    public final Builder start(@Nullable Integer start) {
      this.start = start;
      return this;
    }

    /**
     * Initializes the value for the {@link Sample.EntityWithValue#getEnd() end} attribute.
     * @param end The value for end (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("end")
    public final Builder end(@Nullable Integer end) {
      this.end = end;
      return this;
    }

    /**
     * Adds one element to {@link Sample.EntityWithValue#getSubEntities() subEntities} list.
     * @param element A subEntities element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder subEntity(Sample.EntityWithValue element) {
      this.subEntities.add(Objects.requireNonNull(element, "subEntities element"));
      return this;
    }

    /**
     * Adds elements to {@link Sample.EntityWithValue#getSubEntities() subEntities} list.
     * @param elements An array of subEntities elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder subEntities(Sample.EntityWithValue... elements) {
      for (Sample.EntityWithValue element : elements) {
        this.subEntities.add(Objects.requireNonNull(element, "subEntities element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link Sample.EntityWithValue#getSubEntities() subEntities} list.
     * @param elements An iterable of subEntities elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("subentities")
    public final Builder subEntities(Iterable<? extends Sample.EntityWithValue> elements) {
      this.subEntities.clear();
      return addAllSubEntities(elements);
    }

    /**
     * Adds elements to {@link Sample.EntityWithValue#getSubEntities() subEntities} list.
     * @param elements An iterable of subEntities elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllSubEntities(Iterable<? extends Sample.EntityWithValue> elements) {
      for (Sample.EntityWithValue element : elements) {
        this.subEntities.add(Objects.requireNonNull(element, "subEntities element"));
      }
      return this;
    }

    /**
     * Builds a new {@link ImmutableEntityWithValue ImmutableEntityWithValue}.
     * @return An immutable instance of EntityWithValue
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableEntityWithValue build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableEntityWithValue(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ENTITY) != 0) attributes.add("entity");
      if ((initBits & INIT_BIT_VALUE) != 0) attributes.add("value");
      return "Cannot build EntityWithValue, some of required attributes are not set " + attributes;
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
