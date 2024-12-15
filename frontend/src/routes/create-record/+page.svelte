<script>
  import {user, isAuthenticated} from '../../stores/auth';
  import {fade} from 'svelte/transition'
  import pb from '$lib/pocket';
  

  let recordName = '';
  let doctorName = '';
  let visitPurpose = '';
  let bloodPressure = '';
  let bodyTemperature = '';
  let heartRate = '';
  let allergies = '';
  let visitDate = '';
  let symptomsFelt = '';
  let diagnosis = '';
  let prescribedMedication = '';
  let medicineIntakeTime = '';
  let additionalNotes = '';

  const handleCreateRecord = async (e) => {
    e.preventDefault();

    const data = {
      "record_title": recordName,
      "doctor_name": doctorName,
      "visit_purpose": visitPurpose,
      "blood_pressure": bloodPressure,
      "body_temperature": bodyTemperature,
      "heart_rate": heartRate,
      "allergies": allergies,
      "visit_date": visitDate,
      "symptoms_felt": symptomsFelt,
      "diagnosis": diagnosis,
      "prescribed_medicine": prescribedMedication,
      "medicine_intake_time": medicineIntakeTime,
      "additional_notes": additionalNotes,
      "user_id": "me5zfhq3n3211dh"
    };

    try {
      const record = await pb.collection('medicalrecords').create(data);
      console.log('Record created:', record);
      window.location.href = '/';
      // Redirect or show success message
    } catch (error) {
      console.error('Error creating record:', error);
      alert('Failed to create record: ' + error.message);
    }
  }

  

</script>

<main class="flex flex-col max-w-[1200px] min-h-screen mx-auto px-6 py-12">
  <form class="flex flex-col gap-4">
    <div>
      <b>Personal Information</b>
      <p class="text-gray-500">This section includes a detailed history of your medical records.</p>
    </div>
  
    <label class="label">
      <span>Record Name</span>
      <input bind:value={recordName} class="input rounded-md py-2 px-4 bg-transparent" type="text"  placeholder="Enter your record name" required/>
    </label>

    <label class="label">
      <span>Doctor Name</span>
      <input bind:value={doctorName} class="input rounded-md py-2 px-4 bg-transparent" type="text"  placeholder="Dr. William Smith" required/>
    </label>

    <label class="label">
      <span>Visit Purpose</span>
      <input bind:value={visitPurpose} class="input rounded-md py-2 px-4 bg-transparent" type="text"  placeholder="Why did you visit?" required/>
    </label>

    <label class="label">
      <span>Blood Pressure</span>
      <input bind:value={bloodPressure} class="input rounded-md py-2 px-4 bg-transparent" type="text"  placeholder="Enter blood pressure" required/>
    </label>

    <label class="label">
      <span>Body Temperature</span>
      <input bind:value={bodyTemperature} class="input rounded-md py-2 px-4 bg-transparent" type="text"  placeholder="Enter body temperature" required/>
    </label>

    <label class="label">
      <span>Heart Rate</span>
      <input bind:value={heartRate} class="input rounded-md py-2 px-4 bg-transparent" type="text"  placeholder="Enter heart rate" required/>
    </label>

    <label class="label">
      <span>Allergies</span>
      <input bind:value={allergies} class="input rounded-md py-2 px-4 bg-transparent" type="text"  placeholder="Enter allergies if any" required/>
    </label>

    <label class="label">
      <span>Date Visited</span>
      <input bind:value={visitDate} class="input rounded-md py-2 px-4 bg-transparent" type="date"  required/>
    </label>

    <div class="grid grid-rows-2 sm:grid-cols-2 gap-4">
      <button type="submit" on:click={handleCreateRecord} class="btn rounded-md variant-ghost-surface w-full">Create New Record</button>
      <a href="/"><button type="button" class="btn rounded-md hover:variant-ghost-error w-full">Cancel</button></a>
    </div>
  </form>
</main>