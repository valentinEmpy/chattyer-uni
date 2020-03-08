package chattyer.nlp.wit;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import okhttp3.OkHttpClient;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link WitContext}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableWitContext.builder()}.
 */
@Generated(from = "WitContext", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableWitContext implements WitContext {
  private final OkHttpClient httpClient;
  private final ObjectMapper objectMapper;
  private final TokenProvider tokenProvider;
  private final String rootWitUrl;
  private final @Nullable String witApiVersion;

  private ImmutableWitContext(ImmutableWitContext.Builder builder) {
    this.httpClient = builder.httpClient;
    this.tokenProvider = builder.tokenProvider;
    this.witApiVersion = builder.witApiVersion;
    if (builder.objectMapper != null) {
      initShim.objectMapper(builder.objectMapper);
    }
    if (builder.rootWitUrl != null) {
      initShim.rootWitUrl(builder.rootWitUrl);
    }
    this.objectMapper = initShim.getObjectMapper();
    this.rootWitUrl = initShim.getRootWitUrl();
    this.initShim = null;
  }

  private static final byte STAGE_INITIALIZING = -1;
  private static final byte STAGE_UNINITIALIZED = 0;
  private static final byte STAGE_INITIALIZED = 1;
  private transient volatile InitShim initShim = new InitShim();

  @Generated(from = "WitContext", generator = "Immutables")
  private final class InitShim {
    private byte objectMapperBuildStage = STAGE_UNINITIALIZED;
    private ObjectMapper objectMapper;

    ObjectMapper getObjectMapper() {
      if (objectMapperBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (objectMapperBuildStage == STAGE_UNINITIALIZED) {
        objectMapperBuildStage = STAGE_INITIALIZING;
        this.objectMapper = Objects.requireNonNull(getObjectMapperInitialize(), "objectMapper");
        objectMapperBuildStage = STAGE_INITIALIZED;
      }
      return this.objectMapper;
    }

    void objectMapper(ObjectMapper objectMapper) {
      this.objectMapper = objectMapper;
      objectMapperBuildStage = STAGE_INITIALIZED;
    }

    private byte rootWitUrlBuildStage = STAGE_UNINITIALIZED;
    private String rootWitUrl;

    String getRootWitUrl() {
      if (rootWitUrlBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (rootWitUrlBuildStage == STAGE_UNINITIALIZED) {
        rootWitUrlBuildStage = STAGE_INITIALIZING;
        this.rootWitUrl = Objects.requireNonNull(getRootWitUrlInitialize(), "rootWitUrl");
        rootWitUrlBuildStage = STAGE_INITIALIZED;
      }
      return this.rootWitUrl;
    }

    void rootWitUrl(String rootWitUrl) {
      this.rootWitUrl = rootWitUrl;
      rootWitUrlBuildStage = STAGE_INITIALIZED;
    }

    private String formatInitCycleMessage() {
      List<String> attributes = new ArrayList<>();
      if (objectMapperBuildStage == STAGE_INITIALIZING) attributes.add("objectMapper");
      if (rootWitUrlBuildStage == STAGE_INITIALIZING) attributes.add("rootWitUrl");
      return "Cannot build WitContext, attribute initializers form cycle " + attributes;
    }
  }

  private ObjectMapper getObjectMapperInitialize() {
    return WitContext.super.getObjectMapper();
  }

  private String getRootWitUrlInitialize() {
    return WitContext.super.getRootWitUrl();
  }

  /**
   * @return The value of the {@code httpClient} attribute
   */
  @Override
  public OkHttpClient getHttpClient() {
    return httpClient;
  }

  /**
   * @return The value of the {@code objectMapper} attribute
   */
  @Override
  public ObjectMapper getObjectMapper() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.getObjectMapper()
        : this.objectMapper;
  }

  /**
   * @return The value of the {@code tokenProvider} attribute
   */
  @Override
  public TokenProvider getTokenProvider() {
    return tokenProvider;
  }

  /**
   * @return The value of the {@code rootWitUrl} attribute
   */
  @Override
  public String getRootWitUrl() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.getRootWitUrl()
        : this.rootWitUrl;
  }

  /**
   * @return The value of the {@code witApiVersion} attribute
   */
  @Override
  public Optional<String> getWitApiVersion() {
    return Optional.ofNullable(witApiVersion);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableWitContext} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableWitContext
        && equalTo((ImmutableWitContext) another);
  }

  private boolean equalTo(ImmutableWitContext another) {
    return httpClient.equals(another.httpClient)
        && objectMapper.equals(another.objectMapper)
        && tokenProvider.equals(another.tokenProvider)
        && rootWitUrl.equals(another.rootWitUrl)
        && Objects.equals(witApiVersion, another.witApiVersion);
  }

  /**
   * Computes a hash code from attributes: {@code httpClient}, {@code objectMapper}, {@code tokenProvider}, {@code rootWitUrl}, {@code witApiVersion}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + httpClient.hashCode();
    h += (h << 5) + objectMapper.hashCode();
    h += (h << 5) + tokenProvider.hashCode();
    h += (h << 5) + rootWitUrl.hashCode();
    h += (h << 5) + Objects.hashCode(witApiVersion);
    return h;
  }

  /**
   * Prints the immutable value {@code WitContext} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("WitContext{");
    builder.append("httpClient=").append(httpClient);
    builder.append(", ");
    builder.append("objectMapper=").append(objectMapper);
    builder.append(", ");
    builder.append("tokenProvider=").append(tokenProvider);
    builder.append(", ");
    builder.append("rootWitUrl=").append(rootWitUrl);
    if (witApiVersion != null) {
      builder.append(", ");
      builder.append("witApiVersion=").append(witApiVersion);
    }
    return builder.append("}").toString();
  }

  /**
   * Creates a builder for {@link ImmutableWitContext ImmutableWitContext}.
   * <pre>
   * ImmutableWitContext.builder()
   *    .httpClient(okhttp3.OkHttpClient) // required {@link WitContext#getHttpClient() httpClient}
   *    .objectMapper(com.fasterxml.jackson.databind.ObjectMapper) // optional {@link WitContext#getObjectMapper() objectMapper}
   *    .tokenProvider(chattyer.nlp.wit.TokenProvider) // required {@link WitContext#getTokenProvider() tokenProvider}
   *    .rootWitUrl(String) // optional {@link WitContext#getRootWitUrl() rootWitUrl}
   *    .witApiVersion(String) // optional {@link WitContext#getWitApiVersion() witApiVersion}
   *    .build();
   * </pre>
   * @return A new ImmutableWitContext builder
   */
  public static ImmutableWitContext.Builder builder() {
    return new ImmutableWitContext.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableWitContext ImmutableWitContext}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "WitContext", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_HTTP_CLIENT = 0x1L;
    private static final long INIT_BIT_TOKEN_PROVIDER = 0x2L;
    private long initBits = 0x3L;

    private @Nullable OkHttpClient httpClient;
    private @Nullable ObjectMapper objectMapper;
    private @Nullable TokenProvider tokenProvider;
    private @Nullable String rootWitUrl;
    private @Nullable String witApiVersion;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code WitContext} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(WitContext instance) {
      Objects.requireNonNull(instance, "instance");
      httpClient(instance.getHttpClient());
      objectMapper(instance.getObjectMapper());
      tokenProvider(instance.getTokenProvider());
      rootWitUrl(instance.getRootWitUrl());
      Optional<String> witApiVersionOptional = instance.getWitApiVersion();
      if (witApiVersionOptional.isPresent()) {
        witApiVersion(witApiVersionOptional);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link WitContext#getHttpClient() httpClient} attribute.
     * @param httpClient The value for httpClient 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder httpClient(OkHttpClient httpClient) {
      this.httpClient = Objects.requireNonNull(httpClient, "httpClient");
      initBits &= ~INIT_BIT_HTTP_CLIENT;
      return this;
    }

    /**
     * Initializes the value for the {@link WitContext#getObjectMapper() objectMapper} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link WitContext#getObjectMapper() objectMapper}.</em>
     * @param objectMapper The value for objectMapper 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder objectMapper(ObjectMapper objectMapper) {
      this.objectMapper = Objects.requireNonNull(objectMapper, "objectMapper");
      return this;
    }

    /**
     * Initializes the value for the {@link WitContext#getTokenProvider() tokenProvider} attribute.
     * @param tokenProvider The value for tokenProvider 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder tokenProvider(TokenProvider tokenProvider) {
      this.tokenProvider = Objects.requireNonNull(tokenProvider, "tokenProvider");
      initBits &= ~INIT_BIT_TOKEN_PROVIDER;
      return this;
    }

    /**
     * Initializes the value for the {@link WitContext#getRootWitUrl() rootWitUrl} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link WitContext#getRootWitUrl() rootWitUrl}.</em>
     * @param rootWitUrl The value for rootWitUrl 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder rootWitUrl(String rootWitUrl) {
      this.rootWitUrl = Objects.requireNonNull(rootWitUrl, "rootWitUrl");
      return this;
    }

    /**
     * Initializes the optional value {@link WitContext#getWitApiVersion() witApiVersion} to witApiVersion.
     * @param witApiVersion The value for witApiVersion
     * @return {@code this} builder for chained invocation
     */
    public final Builder witApiVersion(String witApiVersion) {
      this.witApiVersion = Objects.requireNonNull(witApiVersion, "witApiVersion");
      return this;
    }

    /**
     * Initializes the optional value {@link WitContext#getWitApiVersion() witApiVersion} to witApiVersion.
     * @param witApiVersion The value for witApiVersion
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder witApiVersion(Optional<String> witApiVersion) {
      this.witApiVersion = witApiVersion.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableWitContext ImmutableWitContext}.
     * @return An immutable instance of WitContext
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableWitContext build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableWitContext(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_HTTP_CLIENT) != 0) attributes.add("httpClient");
      if ((initBits & INIT_BIT_TOKEN_PROVIDER) != 0) attributes.add("tokenProvider");
      return "Cannot build WitContext, some of required attributes are not set " + attributes;
    }
  }
}
