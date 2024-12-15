<script>
  import pb from '../../../lib/pocket';
  export let data;
  const { record } = data;

  const handleDeleteRecord = async (id) => {
    await pb.collection('medicalrecords').delete(id)
    .then(() => {
      window.location.href = '/';
    })
    .catch((error) => {
      console.error('Error deleting record:', error);
    })
  }
</script>

<div class="container mx-auto p-4">
  <div class="bg-white shadow-md rounded-lg p-6">
    <h2 class="text-2xl font-bold mb-4">{record.record_title}</h2>

    <div class="mb-4">
      <p class="text-gray-700"><b>Doctor Name:</b> {record.doctor_name}</p>
    </div>
    <div class="mb-4">
      <p class="text-gray-700"><b>Visit Purpose:</b> {record.visit_purpose}</p>
    </div>
    <div class="mb-4">
      <p class="text-gray-700"><b>Blood Pressure:</b> {record.blood_pressure}</p>
    </div>
    <div class="mb-4">
      <p class="text-gray-700"><b>Body Temperature:</b> {record.body_temperature}</p>
    </div>
    <div class="mb-4">
      <p class="text-gray-700"><b>Heart Rate:</b> {record.heart_rate}</p>
    </div>
    <div class="mb-4">
      <p class="text-gray-700"><b>Allergies:</b> {record.allergies}</p>
    </div>
    <div class="mb-4">
      <p class="text-gray-700"><b>Date Visited:</b> {record.visit_date}</p>
    </div>
    <div class="mb-4">
      <p class="text-gray-700"><b>Symptoms Felt:</b> {record.symptoms_felt}</p>
    </div>
    <div class="mb-4">
      <p class="text-gray-700"><b>Diagnosis:</b> {record.diagnosis}</p>
    </div>
    <div class="mb-4">
      <p class="text-gray-700"><b>Prescribed Medicine:</b> {record.prescribed_medicine}</p>
    </div>
    <div class="mb-4">
      <p class="text-gray-700"><b>Time To Intake Medicine:</b> {record.medicine_intake_time}</p>
    </div>
    <div class="mb-4">
      <p class="text-gray-700"><b>Additional Notes:</b> {record.additional_notes}</p>
    </div>
  </div>

  <button class="btn variant-form-material mt-4 bg-red-300 font-medium text-red-800 hover:text-red-300 hover:bg-red-800" on:click={handleDeleteRecord(record.id)}>Delete Record</button>
</div>