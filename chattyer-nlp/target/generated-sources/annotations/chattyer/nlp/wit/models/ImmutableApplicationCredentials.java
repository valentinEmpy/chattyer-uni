package chattyer.nlp.wit.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link ApplicationCredentials}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableApplicationCredentials.builder()}.
 */
@Generated(from = "ApplicationCredentials", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ImmutableApplicationCredentials implements ApplicationCredentials {
  private final String accessToken;
  private final String appId;

  private ImmutableApplicationCredentials(ImmutableApplicationCredentials.Builder builder) {
    this.accessToken = builder.accessToken;
    this.appId = builder.appId;
  }

  /**
   * @return The value of the {@code accessToken} attribute
   */
  @JsonProperty("access_token")
  @Override
  public String getAccessToken() {
    return accessToken;
  }

  /**
   * @return The value of the {@code appId} attribute
   */
  @JsonProperty("app_id")
  @Override
  public String getAppId() {
    return appId;
  }

  /**
   * This instance is equal to all instances of {@code ImmutableApplicationCredentials} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableApplicationCredentials
        && equalTo((ImmutableApplicationCredentials) another);
  }

  private boolean equalTo(ImmutableApplicationCredentials another) {
    return accessToken.equals(another.accessToken)
        && appId.equals(another.appId);
  }

  /**
   * Computes a hash code from attributes: {@code accessToken}, {@code appId}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + accessToken.hashCode();
    h += (h << 5) + appId.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ApplicationCredentials} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "ApplicationCredentials{"
        + "accessToken=" + accessToken
        + ", appId=" + appId
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "ApplicationCredentials", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements ApplicationCredentials {
    @Nullable String accessToken;
    @Nullable String appId;
    @JsonProperty("access_token")
    public void setAccessToken(String accessToken) {
      this.accessToken = accessToken;
    }
    @JsonProperty("app_id")
    public void setAppId(String appId) {
      this.appId = appId;
    }
    @Override
    public String getAccessToken() { throw new UnsupportedOperationException(); }
    @Override
    public String getAppId() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableApplicationCredentials fromJson(Json json) {
    ImmutableApplicationCredentials.Builder builder = ImmutableApplicationCredentials.builder();
    if (json.accessToken != null) {
      builder.accessToken(json.accessToken);
    }
    if (json.appId != null) {
      builder.appId(json.appId);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link ImmutableApplicationCredentials ImmutableApplicationCredentials}.
   * <pre>
   * ImmutableApplicationCredentials.builder()
   *    .accessToken(String) // required {@link ApplicationCredentials#getAccessToken() accessToken}
   *    .appId(String) // required {@link ApplicationCredentials#getAppId() appId}
   *    .build();
   * </pre>
   * @return A new ImmutableApplicationCredentials builder
   */
  public static ImmutableApplicationCredentials.Builder builder() {
    return new ImmutableApplicationCredentials.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableApplicationCredentials ImmutableApplicationCredentials}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "ApplicationCredentials", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ACCESS_TOKEN = 0x1L;
    private static final long INIT_BIT_APP_ID = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String accessToken;
    private @Nullable String appId;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ApplicationCredentials} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ApplicationCredentials instance) {
      Objects.requireNonNull(instance, "instance");
      accessToken(instance.getAccessToken());
      appId(instance.getAppId());
      return this;
    }

    /**
     * Initializes the value for the {@link ApplicationCredentials#getAccessToken() accessToken} attribute.
     * @param accessToken The value for accessToken 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("access_token")
    public final Builder accessToken(String accessToken) {
      this.accessToken = Objects.requireNonNull(accessToken, "accessToken");
      initBits &= ~INIT_BIT_ACCESS_TOKEN;
      return this;
    }

    /**
     * Initializes the value for the {@link ApplicationCredentials#getAppId() appId} attribute.
     * @param appId The value for appId 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("app_id")
    public final Builder appId(String appId) {
      this.appId = Objects.requireNonNull(appId, "appId");
      initBits &= ~INIT_BIT_APP_ID;
      return this;
    }

    /**
     * Builds a new {@link ImmutableApplicationCredentials ImmutableApplicationCredentials}.
     * @return An immutable instance of ApplicationCredentials
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableApplicationCredentials build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableApplicationCredentials(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ACCESS_TOKEN) != 0) attributes.add("accessToken");
      if ((initBits & INIT_BIT_APP_ID) != 0) attributes.add("appId");
      return "Cannot build ApplicationCredentials, some of required attributes are not set " + attributes;
    }
  }
}
