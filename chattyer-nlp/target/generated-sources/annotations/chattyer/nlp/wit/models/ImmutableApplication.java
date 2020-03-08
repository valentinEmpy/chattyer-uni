package chattyer.nlp.wit.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Application}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableApplication.builder()}.
 */
@Generated(from = "Application", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ImmutableApplication implements Application {
  private final String name;
  private final String id;
  private final @Nullable String description;
  private final @Nullable String lang;
  private final @Nullable Boolean isPrivate;
  private final @Nullable Integer lastTrainingDurationSecs;
  private final @Nullable String trainingStatus;

  private ImmutableApplication(ImmutableApplication.Builder builder) {
    this.name = builder.name;
    this.id = builder.id;
    this.description = builder.description;
    this.lang = builder.lang;
    this.isPrivate = builder.isPrivate;
    this.lastTrainingDurationSecs = builder.lastTrainingDurationSecs;
    this.trainingStatus = builder.trainingStatus;
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
   * @return The value of the {@code id} attribute
   */
  @JsonProperty("id")
  @Override
  public String getId() {
    return id;
  }

  /**
   * @return The value of the {@code description} attribute
   */
  @JsonProperty("description")
  @Override
  public @Nullable String getDescription() {
    return description;
  }

  /**
   * @return The value of the {@code lang} attribute
   */
  @JsonProperty("lang")
  @Override
  public @Nullable String getLang() {
    return lang;
  }

  /**
   * @return The value of the {@code isPrivate} attribute
   */
  @JsonProperty("private")
  @Override
  public @Nullable Boolean getIsPrivate() {
    return isPrivate;
  }

  /**
   * @return The value of the {@code lastTrainingDurationSecs} attribute
   */
  @JsonProperty("last_training_duration_secs")
  @Override
  public @Nullable Integer getLastTrainingDurationSecs() {
    return lastTrainingDurationSecs;
  }

  /**
   * @return The value of the {@code trainingStatus} attribute
   */
  @JsonProperty("training_status")
  @Override
  public @Nullable String getTrainingStatus() {
    return trainingStatus;
  }

  /**
   * This instance is equal to all instances of {@code ImmutableApplication} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@javax.annotation.Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableApplication
        && equalTo((ImmutableApplication) another);
  }

  private boolean equalTo(ImmutableApplication another) {
    return name.equals(another.name)
        && id.equals(another.id)
        && Objects.equals(description, another.description)
        && Objects.equals(lang, another.lang)
        && Objects.equals(isPrivate, another.isPrivate)
        && Objects.equals(lastTrainingDurationSecs, another.lastTrainingDurationSecs)
        && Objects.equals(trainingStatus, another.trainingStatus);
  }

  /**
   * Computes a hash code from attributes: {@code name}, {@code id}, {@code description}, {@code lang}, {@code isPrivate}, {@code lastTrainingDurationSecs}, {@code trainingStatus}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + id.hashCode();
    h += (h << 5) + Objects.hashCode(description);
    h += (h << 5) + Objects.hashCode(lang);
    h += (h << 5) + Objects.hashCode(isPrivate);
    h += (h << 5) + Objects.hashCode(lastTrainingDurationSecs);
    h += (h << 5) + Objects.hashCode(trainingStatus);
    return h;
  }

  /**
   * Prints the immutable value {@code Application} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Application{"
        + "name=" + name
        + ", id=" + id
        + ", description=" + description
        + ", lang=" + lang
        + ", isPrivate=" + isPrivate
        + ", lastTrainingDurationSecs=" + lastTrainingDurationSecs
        + ", trainingStatus=" + trainingStatus
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "Application", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements Application {
    @javax.annotation.Nullable String name;
    @javax.annotation.Nullable String id;
    @javax.annotation.Nullable String description;
    @javax.annotation.Nullable String lang;
    @javax.annotation.Nullable Boolean isPrivate;
    @javax.annotation.Nullable Integer lastTrainingDurationSecs;
    @javax.annotation.Nullable String trainingStatus;
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @JsonProperty("id")
    public void setId(String id) {
      this.id = id;
    }
    @JsonProperty("description")
    public void setDescription(@Nullable String description) {
      this.description = description;
    }
    @JsonProperty("lang")
    public void setLang(@Nullable String lang) {
      this.lang = lang;
    }
    @JsonProperty("private")
    public void setIsPrivate(@Nullable Boolean isPrivate) {
      this.isPrivate = isPrivate;
    }
    @JsonProperty("last_training_duration_secs")
    public void setLastTrainingDurationSecs(@Nullable Integer lastTrainingDurationSecs) {
      this.lastTrainingDurationSecs = lastTrainingDurationSecs;
    }
    @JsonProperty("training_status")
    public void setTrainingStatus(@Nullable String trainingStatus) {
      this.trainingStatus = trainingStatus;
    }
    @Override
    public String getName() { throw new UnsupportedOperationException(); }
    @Override
    public String getId() { throw new UnsupportedOperationException(); }
    @Override
    public String getDescription() { throw new UnsupportedOperationException(); }
    @Override
    public String getLang() { throw new UnsupportedOperationException(); }
    @Override
    public Boolean getIsPrivate() { throw new UnsupportedOperationException(); }
    @Override
    public Integer getLastTrainingDurationSecs() { throw new UnsupportedOperationException(); }
    @Override
    public String getTrainingStatus() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableApplication fromJson(Json json) {
    ImmutableApplication.Builder builder = ImmutableApplication.builder();
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.id != null) {
      builder.id(json.id);
    }
    if (json.description != null) {
      builder.description(json.description);
    }
    if (json.lang != null) {
      builder.lang(json.lang);
    }
    if (json.isPrivate != null) {
      builder.isPrivate(json.isPrivate);
    }
    if (json.lastTrainingDurationSecs != null) {
      builder.lastTrainingDurationSecs(json.lastTrainingDurationSecs);
    }
    if (json.trainingStatus != null) {
      builder.trainingStatus(json.trainingStatus);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link ImmutableApplication ImmutableApplication}.
   * <pre>
   * ImmutableApplication.builder()
   *    .name(String) // required {@link Application#getName() name}
   *    .id(String) // required {@link Application#getId() id}
   *    .description(String | null) // nullable {@link Application#getDescription() description}
   *    .lang(String | null) // nullable {@link Application#getLang() lang}
   *    .isPrivate(Boolean | null) // nullable {@link Application#getIsPrivate() isPrivate}
   *    .lastTrainingDurationSecs(Integer | null) // nullable {@link Application#getLastTrainingDurationSecs() lastTrainingDurationSecs}
   *    .trainingStatus(String | null) // nullable {@link Application#getTrainingStatus() trainingStatus}
   *    .build();
   * </pre>
   * @return A new ImmutableApplication builder
   */
  public static ImmutableApplication.Builder builder() {
    return new ImmutableApplication.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableApplication ImmutableApplication}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Application", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_ID = 0x2L;
    private long initBits = 0x3L;

    private @javax.annotation.Nullable String name;
    private @javax.annotation.Nullable String id;
    private @javax.annotation.Nullable String description;
    private @javax.annotation.Nullable String lang;
    private @javax.annotation.Nullable Boolean isPrivate;
    private @javax.annotation.Nullable Integer lastTrainingDurationSecs;
    private @javax.annotation.Nullable String trainingStatus;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Application} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Application instance) {
      Objects.requireNonNull(instance, "instance");
      name(instance.getName());
      id(instance.getId());
      @Nullable String descriptionValue = instance.getDescription();
      if (descriptionValue != null) {
        description(descriptionValue);
      }
      @Nullable String langValue = instance.getLang();
      if (langValue != null) {
        lang(langValue);
      }
      @Nullable Boolean isPrivateValue = instance.getIsPrivate();
      if (isPrivateValue != null) {
        isPrivate(isPrivateValue);
      }
      @Nullable Integer lastTrainingDurationSecsValue = instance.getLastTrainingDurationSecs();
      if (lastTrainingDurationSecsValue != null) {
        lastTrainingDurationSecs(lastTrainingDurationSecsValue);
      }
      @Nullable String trainingStatusValue = instance.getTrainingStatus();
      if (trainingStatusValue != null) {
        trainingStatus(trainingStatusValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link Application#getName() name} attribute.
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
     * Initializes the value for the {@link Application#getId() id} attribute.
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
     * Initializes the value for the {@link Application#getDescription() description} attribute.
     * @param description The value for description (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("description")
    public final Builder description(@Nullable String description) {
      this.description = description;
      return this;
    }

    /**
     * Initializes the value for the {@link Application#getLang() lang} attribute.
     * @param lang The value for lang (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("lang")
    public final Builder lang(@Nullable String lang) {
      this.lang = lang;
      return this;
    }

    /**
     * Initializes the value for the {@link Application#getIsPrivate() isPrivate} attribute.
     * @param isPrivate The value for isPrivate (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("private")
    public final Builder isPrivate(@Nullable Boolean isPrivate) {
      this.isPrivate = isPrivate;
      return this;
    }

    /**
     * Initializes the value for the {@link Application#getLastTrainingDurationSecs() lastTrainingDurationSecs} attribute.
     * @param lastTrainingDurationSecs The value for lastTrainingDurationSecs (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("last_training_duration_secs")
    public final Builder lastTrainingDurationSecs(@Nullable Integer lastTrainingDurationSecs) {
      this.lastTrainingDurationSecs = lastTrainingDurationSecs;
      return this;
    }

    /**
     * Initializes the value for the {@link Application#getTrainingStatus() trainingStatus} attribute.
     * @param trainingStatus The value for trainingStatus (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("training_status")
    public final Builder trainingStatus(@Nullable String trainingStatus) {
      this.trainingStatus = trainingStatus;
      return this;
    }

    /**
     * Builds a new {@link ImmutableApplication ImmutableApplication}.
     * @return An immutable instance of Application
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableApplication build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableApplication(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      return "Cannot build Application, some of required attributes are not set " + attributes;
    }
  }
}
