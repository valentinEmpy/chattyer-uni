package chattyer.nlp.wit.analyses;

import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import com.sun.istack.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link AnalyseMessageRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAnalyseMessageRequest.builder()}.
 */
@Generated(from = "AnalyseMessageRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableAnalyseMessageRequest extends AnalyseMessageRequest {
  private final String applicationId;
  private final String message;
  private final @Nullable String threadId;
  private final int maxEntitiesResult;

  private ImmutableAnalyseMessageRequest(ImmutableAnalyseMessageRequest.Builder builder) {
    this.applicationId = builder.applicationId;
    this.message = builder.message;
    this.threadId = builder.threadId;
    this.maxEntitiesResult = builder.maxEntitiesResultIsSet()
        ? builder.maxEntitiesResult
        : super.getMaxEntitiesResult();
  }

  /**
   * @return The value of the {@code applicationId} attribute
   */
  @Override
  public String getApplicationId() {
    return applicationId;
  }

  /**
   * @return The value of the {@code message} attribute
   */
  @Override
  public String getMessage() {
    return message;
  }

  /**
   * @return The value of the {@code threadId} attribute
   */
  @Override
  public @Nullable String getThreadId() {
    return threadId;
  }

  /**
   * @return The value of the {@code maxEntitiesResult} attribute
   */
  @Override
  public int getMaxEntitiesResult() {
    return maxEntitiesResult;
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAnalyseMessageRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@javax.annotation.Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAnalyseMessageRequest
        && equalTo((ImmutableAnalyseMessageRequest) another);
  }

  private boolean equalTo(ImmutableAnalyseMessageRequest another) {
    return applicationId.equals(another.applicationId)
        && message.equals(another.message)
        && Objects.equals(threadId, another.threadId)
        && maxEntitiesResult == another.maxEntitiesResult;
  }

  /**
   * Computes a hash code from attributes: {@code applicationId}, {@code message}, {@code threadId}, {@code maxEntitiesResult}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + applicationId.hashCode();
    h += (h << 5) + message.hashCode();
    h += (h << 5) + Objects.hashCode(threadId);
    h += (h << 5) + maxEntitiesResult;
    return h;
  }

  /**
   * Prints the immutable value {@code AnalyseMessageRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "AnalyseMessageRequest{"
        + "applicationId=" + applicationId
        + ", message=" + message
        + ", threadId=" + threadId
        + ", maxEntitiesResult=" + maxEntitiesResult
        + "}";
  }

  private static ImmutableAnalyseMessageRequest validate(ImmutableAnalyseMessageRequest instance) {
    instance.isValid();
    return instance;
  }

  /**
   * Creates a builder for {@link ImmutableAnalyseMessageRequest ImmutableAnalyseMessageRequest}.
   * <pre>
   * ImmutableAnalyseMessageRequest.builder()
   *    .applicationId(String) // required {@link AnalyseMessageRequest#getApplicationId() applicationId}
   *    .message(String) // required {@link AnalyseMessageRequest#getMessage() message}
   *    .threadId(String | null) // nullable {@link AnalyseMessageRequest#getThreadId() threadId}
   *    .maxEntitiesResult(int) // optional {@link AnalyseMessageRequest#getMaxEntitiesResult() maxEntitiesResult}
   *    .build();
   * </pre>
   * @return A new ImmutableAnalyseMessageRequest builder
   */
  public static ImmutableAnalyseMessageRequest.Builder builder() {
    return new ImmutableAnalyseMessageRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAnalyseMessageRequest ImmutableAnalyseMessageRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "AnalyseMessageRequest", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_APPLICATION_ID = 0x1L;
    private static final long INIT_BIT_MESSAGE = 0x2L;
    private static final long OPT_BIT_MAX_ENTITIES_RESULT = 0x1L;
    private long initBits = 0x3L;
    private long optBits;

    private @javax.annotation.Nullable String applicationId;
    private @javax.annotation.Nullable String message;
    private @javax.annotation.Nullable String threadId;
    private int maxEntitiesResult;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code chattyer.nlp.wit.analyses.AnalyseMessageRequest} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(AnalyseMessageRequest instance) {
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
      if (object instanceof AnalyseMessageRequest) {
        AnalyseMessageRequest instance = (AnalyseMessageRequest) object;
        @Nullable String threadIdValue = instance.getThreadId();
        if (threadIdValue != null) {
          threadId(threadIdValue);
        }
        message(instance.getMessage());
        maxEntitiesResult(instance.getMaxEntitiesResult());
      }
      if (object instanceof AbstractApplicationScopedWitRequest) {
        AbstractApplicationScopedWitRequest instance = (AbstractApplicationScopedWitRequest) object;
        applicationId(instance.getApplicationId());
      }
    }

    /**
     * Initializes the value for the {@link AnalyseMessageRequest#getApplicationId() applicationId} attribute.
     * @param applicationId The value for applicationId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder applicationId(String applicationId) {
      this.applicationId = Objects.requireNonNull(applicationId, "applicationId");
      initBits &= ~INIT_BIT_APPLICATION_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link AnalyseMessageRequest#getMessage() message} attribute.
     * @param message The value for message 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder message(String message) {
      this.message = Objects.requireNonNull(message, "message");
      initBits &= ~INIT_BIT_MESSAGE;
      return this;
    }

    /**
     * Initializes the value for the {@link AnalyseMessageRequest#getThreadId() threadId} attribute.
     * @param threadId The value for threadId (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder threadId(@Nullable String threadId) {
      this.threadId = threadId;
      return this;
    }

    /**
     * Initializes the value for the {@link AnalyseMessageRequest#getMaxEntitiesResult() maxEntitiesResult} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link AnalyseMessageRequest#getMaxEntitiesResult() maxEntitiesResult}.</em>
     * @param maxEntitiesResult The value for maxEntitiesResult 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder maxEntitiesResult(int maxEntitiesResult) {
      this.maxEntitiesResult = maxEntitiesResult;
      optBits |= OPT_BIT_MAX_ENTITIES_RESULT;
      return this;
    }

    /**
     * Builds a new {@link ImmutableAnalyseMessageRequest ImmutableAnalyseMessageRequest}.
     * @return An immutable instance of AnalyseMessageRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAnalyseMessageRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return ImmutableAnalyseMessageRequest.validate(new ImmutableAnalyseMessageRequest(this));
    }

    private boolean maxEntitiesResultIsSet() {
      return (optBits & OPT_BIT_MAX_ENTITIES_RESULT) != 0;
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_APPLICATION_ID) != 0) attributes.add("applicationId");
      if ((initBits & INIT_BIT_MESSAGE) != 0) attributes.add("message");
      return "Cannot build AnalyseMessageRequest, some of required attributes are not set " + attributes;
    }
  }
}
