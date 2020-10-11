<template id="observations-overview">
   <div>
       <h1>Planet systems</h1>
        <ul class="observations-overview-list">
            <li v-for="observations in observations">
                <a v-if="observations.bird" :href="`/observations/${observations.bird.name.trim()}`" class="link-to-observations-details">
                    <div class="single-observations-container" >
                        <h1>{{observations.id}}</h1>
                        <h1 v-if="observations.bird">{{observations.bird.name}}</h1>
                        <img v-if="observations.bird.pictureURL" class="cover-image-frontpage" v-bind:src="observations.bird.pictureURL">
                    </div>
                </a>
                <a v-if="observations.amphibian" :href="`/observations/${observations.amphibian.name.trim()}`" class="link-to-observations-details">
                    <div class="single-observations-container" >
                        <h1>{{observations.id}}</h1>
                        <h1 v-if="observations.amphibian">{{observations.amphibian.name}}</h1>
                        <img v-if="observations.amphibian.pictureURL" class="cover-image-frontpage" v-bind:src="observations.amphibian.pictureURL">
                    </div>
                </a>
                <a v-if="observations.invertebrate" :href="`/observations/${observations.invertebrate.name.trim()}`" class="link-to-observations-details">
                    <div class="single-observations-container" >
                        <h1>{{observations.id}}</h1>
                        <h1 v-if="observations.invertebrate">{{observations.invertebrate.name}}</h1>
                        <img v-if="observations.invertebrate.pictureURL" class="cover-image-frontpage" v-bind:src="observations.invertebrate.pictureURL">
                    </div>
                </a>
            </li>
        </ul>
   </div>
</template>
<script>
    Vue.component("observations-overview", {
        template: "#observations-overview",
        data: () => ({
            observations: [],
        }),
        created() {
            fetch("/api/observations")
                .then(res => res.json())
                .then(res => {
                   this.observations = res;
                })
                .catch(() => alert("Error while fetching observations"));
        }
    });
</script>
<style>
    li{
        list-style-type: none;
    }

    .observations-overview-list{
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
    }

    .observations-overview-list li{
        padding: 10px;
        border: 1px solid white;
        border-radius: 15px;
    }

    .link-to-observations-details{
        width: 400px;
        height:100px;
        text-decoration: none;
        color: white;
    }

    div.single-observations-container{
        overflow: hidden;
        width: 500px;
        background-color: #000000;
        margin: 0 auto;
        opacity: 0.96;
        text-align: center;
    }

    div.single-observations-container:hover{
        opacity: 1.0;
        overflow: hidden;
        -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }

    img.cover-image-frontpage {
        height: auto;
        width: 100%;
        padding-bottom: 20px;
        max-height: 280px;
    }

</style>