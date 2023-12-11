<template>
  <div class="content-wrapper">
    <NavbarComponent></NavbarComponent>
    <div class="row">
      <div class="col-md-3">
        <UserBriefCaseComponent :user="userProfile"/>
      </div>
      <div class="col-md-9">
        <UserExamGradeHistoryComponent :exams="exams"/>
      </div>
    </div>
    <FooterComponent/>
  </div>
</template>
<script>
import NavbarComponent from "@/components/NavbarComponent.vue";
import UserBriefCaseComponent from "@/components/UserProfile/UserBriefCaseComponent.vue";
import UserExamGradeHistoryComponent from "@/components/UserProfile/UserExamGradeHistoryComponent.vue";
import FooterComponent from "@/components/FooterComponent.vue";
export default {
  components: {
    NavbarComponent,
    UserBriefCaseComponent,
    UserExamGradeHistoryComponent,
    FooterComponent
},
  data() {
    return {
      userProfile: {
        name: "John Doe",
        email: "john@example.com",
        // 更多用户信息
      },
      exams: [
        { id: 1, name: "Math Exam", score: 80, date: "2023-01-15" },
        { id: 2, name: "Physics Exam", score: 90, date: "2023-02-20" },
        // 更多考试信息
      ],
    };
  },
};
</script>
<style>
.content-wrapper {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}
</style>
