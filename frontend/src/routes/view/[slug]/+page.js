import pb from '$lib/pocket.js';

export const load = async ({ params }) => {
  console.log('Params:', params);

  const fetchRecord = async (id) => {
    try {
      const record = await pb.collection('medicalrecords').getOne(id);
      return record;
    } catch (error) {
      console.error('Error fetching record:', error);
      throw new Error('Failed to fetch record');
    }
  };

  try {
    const record = await fetchRecord(params.slug);
    return {
      record
    };
  } catch (error) {
    console.error('Error in load function:', error);
    return {
      status: 500,
      error: new Error('Internal Server Error')
    };
  }
};