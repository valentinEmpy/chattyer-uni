package chattyer.nlp.wit.client.entities;

import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link PostEntityRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePostEntityRequest.builder()}.
 */
@Generated(from = "PostEntityRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutablePostEntityRequest extends PostEntityRequest {
  private final String applicationId;
  private final String id;
  private final @Nullable String doc;

  private ImmutablePostEntityRequest(ImmutablePostEntityRequest.Builder builder) {
    this.applicationId = builder.applicationId;
    this.id = builder.id;
    this.doc = builder.doc;
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
  @Override
  public String getId() {
    return id;
  }

  /**
   * @return The value of the {@code doc} attribute
   */
  @JsonProperty("doc")
  @Override
  public @Nullable String getDoc() {
    return doc;
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePostEntityRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@javax.annotation.Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePostEntityRequest
        && equalTo((ImmutablePostEntityRequest) another);
  }

  private boolean equalTo(ImmutablePostEntityRequest another) {
    return applicationId.equals(another.applicationId)
        && id.equals(another.id)
        && Objects.equals(doc, another.doc);
  }

  /**
   * Computes a hash code from attributes: {@code applicationId}, {@code id}, {@code doc}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + applicationId.hashCode();
    h += (h << 5) + id.hashCode();
    h += (h << 5) + Objects.hashCode(doc);
    return h;
  }

  /**
   * Prints the immutable value {@code PostEntityRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "PostEntityRequest{"
        + "applicationId=" + applicationId
        + ", id=" + id
        + ", doc=" + doc
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "PostEntityRequest", generator = "Immutables")
  @Deprecated
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends PostEntityRequest {
    @javax.annotation.Nullable String applicationId;
    @javax.annotation.Nullable String id;
    @javax.annotation.Nullable String doc;
    @JsonProperty("applicationId")
    @JsonIgnore
    public void setApplicationId(String applicationId) {
      this.applicationId = applicationId;
    }
    @JsonProperty("id")
    public void setId(String id) {
      this.id = id;
    }
    @JsonProperty("doc")
    public void setDoc(@Nullable String doc) {
      this.doc = doc;
    }
    @Override
    public String getApplicationId() { throw new UnsupportedOperationException(); }
    @Override
    public String getId() { throw new UnsupportedOperationException(); }
    @Override
    public String getDoc() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutablePostEntityRequest fromJson(Json json) {
    ImmutablePostEntityRequest.Builder builder = ImmutablePostEntityRequest.builder();
    if (json.applicationId != null) {
      builder.applicationId(json.applicationId);
    }
    if (json.id != null) {
      builder.id(json.id);
    }
    if (json.doc != null) {
      builder.doc(json.doc);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link ImmutablePostEntityRequest ImmutablePostEntityRequest}.
   * <pre>
   * ImmutablePostEntityRequest.builder()
   *    .applicationId(String) // required {@link PostEntityRequest#getApplicationId() applicationId}
   *    .id(String) // required {@link PostEntityRequest#getId() id}
   *    .doc(String | null) // nullable {@link PostEntityRequest#getDoc() doc}
   *    .build();
   * </pre>
   * @return A new ImmutablePostEntityRequest builder
   */
  public static ImmutablePostEntityRequest.Builder builder() {
    return new ImmutablePostEntityRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePostEntityRequest ImmutablePostEntityRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "PostEntityRequest", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_APPLICATION_ID = 0x1L;
    private static final long INIT_BIT_ID = 0x2L;
    private long initBits = 0x3L;

    private @javax.annotation.Nullable String applicationId;
    private @javax.annotation.Nullable String id;
    private @javax.annotation.Nullable String doc;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code chattyer.nlp.wit.client.entities.PostEntityRequest} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(PostEntityRequest instance) {
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
      if (object instanceof PostEntityRequest) {
        PostEntityRequest instance = (PostEntityRequest) object;
        @Nullable String docValue = instance.getDoc();
        if (docValue != null) {
          doc(docValue);
        }
        id(instance.getId());
      }
      if (object instanceof AbstractApplicationScopedWitRequest) {
        AbstractApplicationScopedWitRequest instance = (AbstractApplicationScopedWitRequest) object;
        applicationId(instance.getApplicationId());
      }
    }

    /**
     * Initializes the value for the {@link PostEntityRequest#getApplicationId() applicationId} attribute.
     * @param applicationId The value for applicationId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder applicationId(String applicationId) {
      this.applicationId = Objects.requireNonNull(applicationId, "applicationId");
      initBits &= ~INIT_BIT_APPLICATION_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link PostEntityRequest#getId() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder id(String id) {
      this.id = Objects.requireNonNull(id, "id");
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link PostEntityRequest#getDoc() doc} attribute.
     * @param doc The value for doc (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder doc(@Nullable String doc) {
      this.doc = doc;
      return this;
    }

    /**
     * Builds a new {@link ImmutablePostEntityRequest ImmutablePostEntityRequest}.
     * @return An immutable instance of PostEntityRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePostEntityRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePostEntityRequest(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_APPLICATION_ID) != 0) attributes.add("applicationId");
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      return "Cannot build PostEntityRequest, some of required attributes are not set " + attributes;
    }
  }
}
