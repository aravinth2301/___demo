<template>
  <div>
    <div class="container">
      <div class="columns">
        <div class="column" />
      </div>
      <div class="columns">
        <div class="column">
          <a href="/vapp/data">
            <DashboardCard
              src-img="https://wallpaperaccess.com/full/445334.jpg"
              icon-img="data:image/png;base64,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"
            />
          </a>
        </div>
        <div class="column">
          <DashboardCard
            icon-img="https://cdn4.iconfinder.com/data/icons/logos-and-brands/512/21_Angular_logo_logos-512.png"
            src-img="https://a-static.besthdwallpaper.com/new-zealand-natural-landscape-wallpaper-1280x960-2934_20.jpg"
          />
        </div>
        <div class="column">
          <DashboardCard
            icon-img="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/React-icon.svg/1024px-React-icon.svg.png"
            src-img="https://nnimgt-a.akamaihd.net/transform/v1/crop/frm/qPp7hNdixHQMTmePtAfTbh/212ce9ce-39e3-459f-8d7e-bd50458d213d.jpg/r151_0_648_280_w1200_h678_fmax.jpg"
          />
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import DashboardCard from "./components/DashboardCard.vue";
export default {
  components: {
    DashboardCard
  }
};
</script>
