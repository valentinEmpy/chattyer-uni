package chattyer.nlp.wit.client.entities;

import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import chattyer.nlp.wit.models.ExtendedEntity;
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
 * Immutable implementation of {@link UpdateEntityRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUpdateEntityRequest.builder()}.
 */
@Generated(from = "UpdateEntityRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableUpdateEntityRequest extends UpdateEntityRequest {
  private final String applicationId;
  private final String id;
  private final @Nullable String newId;
  private final @Nullable String newDoc;
  private final @Nullable List<ExtendedEntity.Value> newValues;

  private ImmutableUpdateEntityRequest(ImmutableUpdateEntityRequest.Builder builder) {
    this.applicationId = builder.applicationId;
    this.id = builder.id;
    this.newId = builder.newId;
    this.newDoc = builder.newDoc;
    this.newValues = builder.newValues == null ? null : createUnmodifiableList(true, builder.newValues);
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
   * @return The value of the {@code id} attribute
   */
  @JsonProperty("id")
  @JsonIgnore
  @Override
  public String getId() {
    return id;
  }

  /**
   * @return The value of the {@code newId} attribute
   */
  @JsonProperty("id")
  @Override
  public @Nullable String getNewId() {
    return newId;
  }

  /**
   * @return The value of the {@code newDoc} attribute
   */
  @JsonProperty("doc")
  @Override
  public @Nullable String getNewDoc() {
    return newDoc;
  }

  /**
   * @return The value of the {@code newValues} attribute
   */
  @JsonProperty("values")
  @Override
  public @Nullable List<ExtendedEntity.Value> getNewValues() {
    return newValues;
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUpdateEntityRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@javax.annotation.Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUpdateEntityRequest
        && equalTo((ImmutableUpdateEntityRequest) another);
  }

  private boolean equalTo(ImmutableUpdateEntityRequest another) {
    return applicationId.equals(another.applicationId)
        && id.equals(another.id)
        && Objects.equals(newId, another.newId)
        && Objects.equals(newDoc, another.newDoc)
        && Objects.equals(newValues, another.newValues);
  }

  /**
   * Computes a hash code from attributes: {@code applicationId}, {@code id}, {@code newId}, {@code newDoc}, {@code newValues}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + applicationId.hashCode();
    h += (h << 5) + id.hashCode();
    h += (h << 5) + Objects.hashCode(newId);
    h += (h << 5) + Objects.hashCode(newDoc);
    h += (h << 5) + Objects.hashCode(newValues);
    return h;
  }

  /**
   * Prints the immutable value {@code UpdateEntityRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "UpdateEntityRequest{"
        + "applicationId=" + applicationId
        + ", id=" + id
        + ", newId=" + newId
        + ", newDoc=" + newDoc
        + ", newValues=" + newValues
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "UpdateEntityRequest", generator = "Immutables")
  @Deprecated
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends UpdateEntityRequest {
    @javax.annotation.Nullable String applicationId;
    @javax.annotation.Nullable String id;
    @javax.annotation.Nullable String newId;
    @javax.annotation.Nullable String newDoc;
    @javax.annotation.Nullable List<ExtendedEntity.Value> newValues = null;
    @JsonProperty("applicationId")
    @JsonIgnore
    public void setApplicationId(String applicationId) {
      this.applicationId = applicationId;
    }
    @JsonProperty("id")
    @JsonIgnore
    public void setId(String id) {
      this.id = id;
    }
    @JsonProperty("id")
    public void setNewId(@Nullable String newId) {
      this.newId = newId;
    }
    @JsonProperty("doc")
    public void setNewDoc(@Nullable String newDoc) {
      this.newDoc = newDoc;
    }
    @JsonProperty("values")
    public void setNewValues(@Nullable List<ExtendedEntity.Value> newValues) {
      this.newValues = newValues;
    }
    @Override
    public String getApplicationId() { throw new UnsupportedOperationException(); }
    @Override
    public String getId() { throw new UnsupportedOperationException(); }
    @Override
    public String getNewId() { throw new UnsupportedOperationException(); }
    @Override
    public String getNewDoc() { throw new UnsupportedOperationException(); }
    @Override
    public List<ExtendedEntity.Value> getNewValues() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableUpdateEntityRequest fromJson(Json json) {
    ImmutableUpdateEntityRequest.Builder builder = ImmutableUpdateEntityRequest.builder();
    if (json.applicationId != null) {
      builder.applicationId(json.applicationId);
    }
    if (json.id != null) {
      builder.id(json.id);
    }
    if (json.newId != null) {
      builder.newId(json.newId);
    }
    if (json.newDoc != null) {
      builder.newDoc(json.newDoc);
    }
    if (json.newValues != null) {
      builder.addAllNewValues(json.newValues);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link ImmutableUpdateEntityRequest ImmutableUpdateEntityRequest}.
   * <pre>
   * ImmutableUpdateEntityRequest.builder()
   *    .applicationId(String) // required {@link UpdateEntityRequest#getApplicationId() applicationId}
   *    .id(String) // required {@link UpdateEntityRequest#getId() id}
   *    .newId(String | null) // nullable {@link UpdateEntityRequest#getNewId() newId}
   *    .newDoc(String | null) // nullable {@link UpdateEntityRequest#getNewDoc() newDoc}
   *    .newValues(List&amp;lt;chattyer.nlp.wit.models.ExtendedEntity.Value&amp;gt; | null) // nullable {@link UpdateEntityRequest#getNewValues() newValues}
   *    .build();
   * </pre>
   * @return A new ImmutableUpdateEntityRequest builder
   */
  public static ImmutableUpdateEntityRequest.Builder builder() {
    return new ImmutableUpdateEntityRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUpdateEntityRequest ImmutableUpdateEntityRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "UpdateEntityRequest", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_APPLICATION_ID = 0x1L;
    private static final long INIT_BIT_ID = 0x2L;
    private long initBits = 0x3L;

    private @javax.annotation.Nullable String applicationId;
    private @javax.annotation.Nullable String id;
    private @javax.annotation.Nullable String newId;
    private @javax.annotation.Nullable String newDoc;
    private List<ExtendedEntity.Value> newValues = null;

    private Builder() {
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

    /**
     * Fill a builder with attribute values from the provided {@code chattyer.nlp.wit.client.entities.UpdateEntityRequest} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(UpdateEntityRequest instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    private void from(Object object) {
      if (object instanceof AbstractApplicationScopedWitRequest) {
        AbstractApplicationScopedWitRequest instance = (AbstractApplicationScopedWitRequest) object;
        applicationId(instance.getApplicationId());
      }
      if (object instanceof UpdateEntityRequest) {
        UpdateEntityRequest instance = (UpdateEntityRequest) object;
        @Nullable String newDocValue = instance.getNewDoc();
        if (newDocValue != null) {
          newDoc(newDocValue);
        }
        id(instance.getId());
        @Nullable List<ExtendedEntity.Value> newValuesValue = instance.getNewValues();
        if (newValuesValue != null) {
          addAllNewValues(newValuesValue);
        }
        @Nullable String newIdValue = instance.getNewId();
        if (newIdValue != null) {
          newId(newIdValue);
        }
      }
    }

    /**
     * Initializes the value for the {@link UpdateEntityRequest#getApplicationId() applicationId} attribute.
     * @param applicationId The value for applicationId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder applicationId(String applicationId) {
      this.applicationId = Objects.requireNonNull(applicationId, "applicationId");
      initBits &= ~INIT_BIT_APPLICATION_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link UpdateEntityRequest#getId() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder id(String id) {
      this.id = Objects.requireNonNull(id, "id");
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link UpdateEntityRequest#getNewId() newId} attribute.
     * @param newId The value for newId (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder newId(@Nullable String newId) {
      this.newId = newId;
      return this;
    }

    /**
     * Initializes the value for the {@link UpdateEntityRequest#getNewDoc() newDoc} attribute.
     * @param newDoc The value for newDoc (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder newDoc(@Nullable String newDoc) {
      this.newDoc = newDoc;
      return this;
    }

    /**
     * Adds one element to {@link UpdateEntityRequest#getNewValues() newValues} list.
     * @param element A newValues element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder newValue(ExtendedEntity.Value element) {
      if (this.newValues == null) {
        this.newValues = new ArrayList<ExtendedEntity.Value>();
      }
      this.newValues.add(Objects.requireNonNull(element, "newValues element"));
      return this;
    }

    /**
     * Adds elements to {@link UpdateEntityRequest#getNewValues() newValues} list.
     * @param elements An array of newValues elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder newValues(ExtendedEntity.Value... elements) {
      if (this.newValues == null) {
        this.newValues = new ArrayList<ExtendedEntity.Value>();
      }
      for (ExtendedEntity.Value element : elements) {
        this.newValues.add(Objects.requireNonNull(element, "newValues element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link UpdateEntityRequest#getNewValues() newValues} list.
     * @param elements An iterable of newValues elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder newValues(@Nullable Iterable<? extends ExtendedEntity.Value> elements) {
      if (elements == null) {
        this.newValues = null;
        return this;
      }
      this.newValues = new ArrayList<ExtendedEntity.Value>();
      return addAllNewValues(elements);
    }

    /**
     * Adds elements to {@link UpdateEntityRequest#getNewValues() newValues} list.
     * @param elements An iterable of newValues elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllNewValues(Iterable<? extends ExtendedEntity.Value> elements) {
      Objects.requireNonNull(elements, "newValues element");
      if (this.newValues == null) {
        this.newValues = new ArrayList<ExtendedEntity.Value>();
      }
      for (ExtendedEntity.Value element : elements) {
        this.newValues.add(Objects.requireNonNull(element, "newValues element"));
      }
      return this;
    }

    /**
     * Builds a new {@link ImmutableUpdateEntityRequest ImmutableUpdateEntityRequest}.
     * @return An immutable instance of UpdateEntityRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUpdateEntityRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableUpdateEntityRequest(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_APPLICATION_ID) != 0) attributes.add("applicationId");
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      return "Cannot build UpdateEntityRequest, some of required attributes are not set " + attributes;
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
