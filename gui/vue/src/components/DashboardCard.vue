<template>
  <div class="card">
    <div class="card-image">
      <figure class="image is-4by3">
        <img :src="srcImg" alt="Placeholder image" />
      </figure>
    </div>
    <div class="card-content">
      <div class="media">
        <div class="media-left">
          <figure class="image is-48x48">
            <img :src="iconImg" alt="Placeholder image" />
          </figure>
        </div>
        <div class="media-content">
          <p class="title is-4">{{ title }}</p>
          <p class="subtitle is-6">{{ description }}</p>
        </div>
      </div>

      <div class="content">
        {{ content }}
      </div>
    </div>
  </div>
</template>
<script>
export default {
  props: {
    srcImg: {
      type: String,
      default: null
    },
    iconImg: {
      type: String,
      default: null
    },
    title: {
      type: String,
      default: null
    },
    description: {
      type: String,
      default: null
    },
    content: {
      type: String,
      default: null
    }
  }
};
</script>
