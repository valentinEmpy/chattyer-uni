package chattyer.nlp.wit.client.entities;

import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link GetEntityRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableGetEntityRequest.builder()}.
 */
@Generated(from = "GetEntityRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableGetEntityRequest extends GetEntityRequest {
  private final String applicationId;
  private final String entityId;

  private ImmutableGetEntityRequest(ImmutableGetEntityRequest.Builder builder) {
    this.applicationId = builder.applicationId;
    this.entityId = builder.entityId;
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
  @Override
  public String getEntityId() {
    return entityId;
  }

  /**
   * This instance is equal to all instances of {@code ImmutableGetEntityRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableGetEntityRequest
        && equalTo((ImmutableGetEntityRequest) another);
  }

  private boolean equalTo(ImmutableGetEntityRequest another) {
    return applicationId.equals(another.applicationId)
        && entityId.equals(another.entityId);
  }

  /**
   * Computes a hash code from attributes: {@code applicationId}, {@code entityId}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + applicationId.hashCode();
    h += (h << 5) + entityId.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code GetEntityRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "GetEntityRequest{"
        + "applicationId=" + applicationId
        + ", entityId=" + entityId
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "GetEntityRequest", generator = "Immutables")
  @Deprecated
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends GetEntityRequest {
    @Nullable String applicationId;
    @Nullable String entityId;
    @JsonProperty("applicationId")
    @JsonIgnore
    public void setApplicationId(String applicationId) {
      this.applicationId = applicationId;
    }
    @JsonProperty("entityId")
    public void setEntityId(String entityId) {
      this.entityId = entityId;
    }
    @Override
    public String getApplicationId() { throw new UnsupportedOperationException(); }
    @Override
    public String getEntityId() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableGetEntityRequest fromJson(Json json) {
    ImmutableGetEntityRequest.Builder builder = ImmutableGetEntityRequest.builder();
    if (json.applicationId != null) {
      builder.applicationId(json.applicationId);
    }
    if (json.entityId != null) {
      builder.entityId(json.entityId);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link ImmutableGetEntityRequest ImmutableGetEntityRequest}.
   * <pre>
   * ImmutableGetEntityRequest.builder()
   *    .applicationId(String) // required {@link GetEntityRequest#getApplicationId() applicationId}
   *    .entityId(String) // required {@link GetEntityRequest#getEntityId() entityId}
   *    .build();
   * </pre>
   * @return A new ImmutableGetEntityRequest builder
   */
  public static ImmutableGetEntityRequest.Builder builder() {
    return new ImmutableGetEntityRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableGetEntityRequest ImmutableGetEntityRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "GetEntityRequest", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_APPLICATION_ID = 0x1L;
    private static final long INIT_BIT_ENTITY_ID = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String applicationId;
    private @Nullable String entityId;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code chattyer.nlp.wit.client.entities.GetEntityRequest} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(GetEntityRequest instance) {
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
      if (object instanceof GetEntityRequest) {
        GetEntityRequest instance = (GetEntityRequest) object;
        entityId(instance.getEntityId());
      }
      if (object instanceof AbstractApplicationScopedWitRequest) {
        AbstractApplicationScopedWitRequest instance = (AbstractApplicationScopedWitRequest) object;
        applicationId(instance.getApplicationId());
      }
    }

    /**
     * Initializes the value for the {@link GetEntityRequest#getApplicationId() applicationId} attribute.
     * @param applicationId The value for applicationId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder applicationId(String applicationId) {
      this.applicationId = Objects.requireNonNull(applicationId, "applicationId");
      initBits &= ~INIT_BIT_APPLICATION_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link GetEntityRequest#getEntityId() entityId} attribute.
     * @param entityId The value for entityId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityId(String entityId) {
      this.entityId = Objects.requireNonNull(entityId, "entityId");
      initBits &= ~INIT_BIT_ENTITY_ID;
      return this;
    }

    /**
     * Builds a new {@link ImmutableGetEntityRequest ImmutableGetEntityRequest}.
     * @return An immutable instance of GetEntityRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableGetEntityRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableGetEntityRequest(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_APPLICATION_ID) != 0) attributes.add("applicationId");
      if ((initBits & INIT_BIT_ENTITY_ID) != 0) attributes.add("entityId");
      return "Cannot build GetEntityRequest, some of required attributes are not set " + attributes;
    }
  }
}
