<template>
  <div class="container">
    <div class="columns">
      <div class="column"></div>
    </div>
    <Header />
    <div class="columns">
      <div class="column" />
      <div class="column">Search data</div>
      <div class="column" />
    </div>
    <div class="columns">
      <div class="column">
        <section>
          <button
            class="button field is-danger"
            @click="selected = null"
            :disabled="!selected"
          >
            <b-icon icon="close"></b-icon>
            <span>Clear selected</span>
          </button>

          <b-tabs>
            <b-tab-item label="Table">
              <b-table
                :data="data"
                :columns="columns"
                :selected.sync="selected"
                focusable
              >
              </b-table>
            </b-tab-item>

            <b-tab-item label="Selected">
              <pre>{{ selected }}</pre>
            </b-tab-item>
          </b-tabs>
        </section>
      </div>
    </div>
  </div>
</template>
<script>
import Header from "../components/Header";
import { servApi } from "../api.js";
export default {
  components: {
    Header
  },
  mounted() {
    servApi
      .get("/v1/users")
      .then(response => (this.data = response.data))
      .catch(function(error) {
        // handle error
        console.log(error);
      })
      .then(function() {
        // always executed
      });
    console.log(this.data);
  },

  data() {
    return {
      data: [],
      selected: null,
      columns: [
        {
          field: "id",
          label: "ID",
          width: "40",
          numeric: true
        },
        {
          field: "username",
          label: "First Name"
        },
        {
          field: "enabled",
          label: "Enabled",
          centered: true
        },
        {
          field: "accountNonExpired",
          label: "Account Non-Expired",
          centered: true
        },
        {
          field: "accountNonLocked",
          label: "Account Non-Locked",
          centered: true
        },
        {
          field: "credentialsNonExpired",
          label: "Credentials Non-Expired",
          centered: true
        }
      ]
    };
  }
};
</script>
