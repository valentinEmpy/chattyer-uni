package chattyer.nlp.wit.client.entities;

import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
 * Immutable implementation of {@link PostEntityValueRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePostEntityValueRequest.builder()}.
 */
@Generated(from = "PostEntityValueRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutablePostEntityValueRequest
    extends PostEntityValueRequest {
  private final String applicationId;
  private final String entityId;
  private final String entityValue;
  private final List<String> expressions;
  private final @Nullable String metadata;

  private ImmutablePostEntityValueRequest(ImmutablePostEntityValueRequest.Builder builder) {
    this.applicationId = builder.applicationId;
    this.entityId = builder.entityId;
    this.entityValue = builder.entityValue;
    this.expressions = createUnmodifiableList(true, builder.expressions);
    this.metadata = builder.metadata;
  }

  /**
   * @return The value of the {@code applicationId} attribute
   */
  @JsonProperty("applicationId")
  @JsonIgnore
  @Override
  public String getApplicationId() {
    return applicationId;
  }

  /**
   * @return The value of the {@code entityId} attribute
   */
  @JsonProperty("entityId")
  @JsonIgnore
  @Override
  public String getEntityId() {
    return entityId;
  }

  /**
   * @return The value of the {@code entityValue} attribute
   */
  @JsonProperty("value")
  @Override
  public String getEntityValue() {
    return entityValue;
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
   * @return The value of the {@code metadata} attribute
   */
  @JsonProperty("metadata")
  @Override
  public @Nullable String getMetadata() {
    return metadata;
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePostEntityValueRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@javax.annotation.Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePostEntityValueRequest
        && equalTo((ImmutablePostEntityValueRequest) another);
  }

  private boolean equalTo(ImmutablePostEntityValueRequest another) {
    return applicationId.equals(another.applicationId)
        && entityId.equals(another.entityId)
        && entityValue.equals(another.entityValue)
        && expressions.equals(another.expressions)
        && Objects.equals(metadata, another.metadata);
  }

  /**
   * Computes a hash code from attributes: {@code applicationId}, {@code entityId}, {@code entityValue}, {@code expressions}, {@code metadata}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + applicationId.hashCode();
    h += (h << 5) + entityId.hashCode();
    h += (h << 5) + entityValue.hashCode();
    h += (h << 5) + expressions.hashCode();
    h += (h << 5) + Objects.hashCode(metadata);
    return h;
  }

  /**
   * Prints the immutable value {@code PostEntityValueRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "PostEntityValueRequest{"
        + "applicationId=" + applicationId
        + ", entityId=" + entityId
        + ", entityValue=" + entityValue
        + ", expressions=" + expressions
        + ", metadata=" + metadata
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "PostEntityValueRequest", generator = "Immutables")
  @Deprecated
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends PostEntityValueRequest {
    @javax.annotation.Nullable String applicationId;
    @javax.annotation.Nullable String entityId;
    @javax.annotation.Nullable String entityValue;
    @javax.annotation.Nullable List<String> expressions = Collections.emptyList();
    @javax.annotation.Nullable String metadata;
    @JsonProperty("applicationId")
    @JsonIgnore
    public void setApplicationId(String applicationId) {
      this.applicationId = applicationId;
    }
    @JsonProperty("entityId")
    @JsonIgnore
    public void setEntityId(String entityId) {
      this.entityId = entityId;
    }
    @JsonProperty("value")
    public void setEntityValue(String entityValue) {
      this.entityValue = entityValue;
    }
    @JsonProperty("expressions")
    public void setExpressions(List<String> expressions) {
      this.expressions = expressions;
    }
    @JsonProperty("metadata")
    public void setMetadata(@Nullable String metadata) {
      this.metadata = metadata;
    }
    @Override
    public String getApplicationId() { throw new UnsupportedOperationException(); }
    @Override
    public String getEntityId() { throw new UnsupportedOperationException(); }
    @Override
    public String getEntityValue() { throw new UnsupportedOperationException(); }
    @Override
    public List<String> getExpressions() { throw new UnsupportedOperationException(); }
    @Override
    public String getMetadata() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutablePostEntityValueRequest fromJson(Json json) {
    ImmutablePostEntityValueRequest.Builder builder = ImmutablePostEntityValueRequest.builder();
    if (json.applicationId != null) {
      builder.applicationId(json.applicationId);
    }
    if (json.entityId != null) {
      builder.entityId(json.entityId);
    }
    if (json.entityValue != null) {
      builder.entityValue(json.entityValue);
    }
    if (json.expressions != null) {
      builder.addAllExpressions(json.expressions);
    }
    if (json.metadata != null) {
      builder.metadata(json.metadata);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link ImmutablePostEntityValueRequest ImmutablePostEntityValueRequest}.
   * <pre>
   * ImmutablePostEntityValueRequest.builder()
   *    .applicationId(String) // required {@link PostEntityValueRequest#getApplicationId() applicationId}
   *    .entityId(String) // required {@link PostEntityValueRequest#getEntityId() entityId}
   *    .entityValue(String) // required {@link PostEntityValueRequest#getEntityValue() entityValue}
   *    .expression|addAllExpressions(String) // {@link PostEntityValueRequest#getExpressions() expressions} elements
   *    .metadata(String | null) // nullable {@link PostEntityValueRequest#getMetadata() metadata}
   *    .build();
   * </pre>
   * @return A new ImmutablePostEntityValueRequest builder
   */
  public static ImmutablePostEntityValueRequest.Builder builder() {
    return new ImmutablePostEntityValueRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePostEntityValueRequest ImmutablePostEntityValueRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "PostEntityValueRequest", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_APPLICATION_ID = 0x1L;
    private static final long INIT_BIT_ENTITY_ID = 0x2L;
    private static final long INIT_BIT_ENTITY_VALUE = 0x4L;
    private long initBits = 0x7L;

    private @javax.annotation.Nullable String applicationId;
    private @javax.annotation.Nullable String entityId;
    private @javax.annotation.Nullable String entityValue;
    private List<String> expressions = new ArrayList<String>();
    private @javax.annotation.Nullable String metadata;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code chattyer.nlp.wit.client.entities.PostEntityValueRequest} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(PostEntityValueRequest instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    /**
     * Fill a builder with attribute values from the provided {@code chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(AbstractApplicationScopedWitRequest instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    private void from(Object object) {
      if (object instanceof PostEntityValueRequest) {
        PostEntityValueRequest instance = (PostEntityValueRequest) object;
        @Nullable String metadataValue = instance.getMetadata();
        if (metadataValue != null) {
          metadata(metadataValue);
        }
        entityId(instance.getEntityId());
        entityValue(instance.getEntityValue());
        addAllExpressions(instance.getExpressions());
      }
      if (object instanceof AbstractApplicationScopedWitRequest) {
        AbstractApplicationScopedWitRequest instance = (AbstractApplicationScopedWitRequest) object;
        applicationId(instance.getApplicationId());
      }
    }

    /**
     * Initializes the value for the {@link PostEntityValueRequest#getApplicationId() applicationId} attribute.
     * @param applicationId The value for applicationId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder applicationId(String applicationId) {
      this.applicationId = Objects.requireNonNull(applicationId, "applicationId");
      initBits &= ~INIT_BIT_APPLICATION_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link PostEntityValueRequest#getEntityId() entityId} attribute.
     * @param entityId The value for entityId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityId(String entityId) {
      this.entityId = Objects.requireNonNull(entityId, "entityId");
      initBits &= ~INIT_BIT_ENTITY_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link PostEntityValueRequest#getEntityValue() entityValue} attribute.
     * @param entityValue The value for entityValue 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityValue(String entityValue) {
      this.entityValue = Objects.requireNonNull(entityValue, "entityValue");
      initBits &= ~INIT_BIT_ENTITY_VALUE;
      return this;
    }

    /**
     * Adds one element to {@link PostEntityValueRequest#getExpressions() expressions} list.
     * @param element A expressions element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder expression(String element) {
      this.expressions.add(Objects.requireNonNull(element, "expressions element"));
      return this;
    }

    /**
     * Adds elements to {@link PostEntityValueRequest#getExpressions() expressions} list.
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
     * Sets or replaces all elements for {@link PostEntityValueRequest#getExpressions() expressions} list.
     * @param elements An iterable of expressions elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder expressions(Iterable<String> elements) {
      this.expressions.clear();
      return addAllExpressions(elements);
    }

    /**
     * Adds elements to {@link PostEntityValueRequest#getExpressions() expressions} list.
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
     * Initializes the value for the {@link PostEntityValueRequest#getMetadata() metadata} attribute.
     * @param metadata The value for metadata (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder metadata(@Nullable String metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Builds a new {@link ImmutablePostEntityValueRequest ImmutablePostEntityValueRequest}.
     * @return An immutable instance of PostEntityValueRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePostEntityValueRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePostEntityValueRequest(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_APPLICATION_ID) != 0) attributes.add("applicationId");
      if ((initBits & INIT_BIT_ENTITY_ID) != 0) attributes.add("entityId");
      if ((initBits & INIT_BIT_ENTITY_VALUE) != 0) attributes.add("entityValue");
      return "Cannot build PostEntityValueRequest, some of required attributes are not set " + attributes;
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
