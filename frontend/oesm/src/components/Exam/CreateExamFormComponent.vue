<template>
  <div class="container mt-5">
    <div class="row">
      <div class="col-md-6 offset-md-3">
        <div class="card">
          <div class="card-body">
            <h1 class="card-title text-center">Create Exam</h1>
            <form @submit.prevent="submitExam">
              <div class="mb-3">
                <label for="examName" class="form-label">Exam Name:</label>
                <input
                  type="text"
                  class="form-control"
                  id="examName"
                  :value="examConfig.examName"
                  required
                  @input="updateMessage($event, 'examName')"
                />
              </div>
              <!-- Class ID Field -->
              <div class="mb-3">
                <label for="classId" class="form-label">Class ID:</label>
                <input
                  type="number"
                  class="form-control"
                  id="classId"
                  :value="examConfig.classId"
                  required
                  @input="updateMessage($event, 'classId')"
                />
              </div>

              <!-- Number of Questions Field -->
              <div class="mb-3">
                <label for="examQuestionCount" class="form-label"
                  >Number of Questions:</label
                >
                <input
                  type="number"
                  class="form-control"
                  id="examQuestionCount"
                  :value="examConfig.examQuestionCount"
                  required
                  @input="updateMessage($event, 'examQuestionCount')"
                />
              </div>

              <!-- Start Time Field -->
              <div class="mb-3">
                <label for="startTime" class="form-label">Start Time:</label>
                <input
                  type="datetime-local"
                  class="form-control"
                  id="examStartTimeStamp"
                  :value="examConfig.examStartTimeStamp"
                  required  
                  @input="updateMessage($event, 'examStartTimeStamp')"
                />
              </div>

              <!-- End Time Field -->
              <div class="mb-3">
                <label for="endTime" class="form-label">End Time:</label>
                <input
                  type="datetime-local"
                  class="form-control"
                  id="examEndTimeStamp"
                  :value="examConfig.examEndTimeStamp"
                  required
                  @input="updateMessage($event, 'examEndTimeStamp')"
                />
              </div>

              <!-- Submit Button -->
              <button type="submit" class="btn btn-primary w-100">
                Create Exam
              </button>

            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import moment from 'moment';
export default {
  computed: {
    ...mapState("exam", ["examConfig"]),
  },
  methods: {
    ...mapActions("exam", ["submitExamData"]),
    async updateMessage(event, fieldName) {
      this.$store.commit("exam/UPDATE_EXAM_CONFIG", {
        fieldName: fieldName,
        value: event.target.value,
      });
    },
    async submitExam() {
      if (this.examConfig.startTime >= this.examConfig.endTime) {
        alert("The end time must be after the start time.");
        return;
      }
      const formattedExamStartTime = moment(this.examConfig.examStartTimeStamp).format('YYYY-MM-DD HH:mm:ss');
      const formattedExamEndTime = moment(this.examConfig.examEndTimeStamp).format('YYYY-MM-DD HH:mm:ss');
      console.log(formattedExamStartTime);
      console.log(formattedExamEndTime);
      this.$store.commit("exam/UPDATE_EXAM_CONFIG", {
        fieldName: "examStartTimeStamp",
        value: formattedExamStartTime,
      });
      
      this.$store.commit("exam/UPDATE_EXAM_CONFIG", {
        fieldName: "examEndTimeStamp",
        value: formattedExamEndTime,
      });
      
      this.submitExamData(this.examConfig);
    },
  },
};
</script>

<style>
/* You can add custom styles here if needed */
</style>
