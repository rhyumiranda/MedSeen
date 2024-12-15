/// <reference path="../pb_data/types.d.ts" />
migrate((app) => {
  const collection = app.findCollectionByNameOrId("pbc_1125843985")

  // update collection data
  unmarshal({
    "deleteRule": "@request.auth.id = user_id",
    "listRule": "@request.auth.id = user_id",
    "name": "medicalRecord"
  }, collection)

  return app.save(collection)
}, (app) => {
  const collection = app.findCollectionByNameOrId("pbc_1125843985")

  // update collection data
  unmarshal({
    "deleteRule": "@request.auth.id != user_id",
    "listRule": "@request.auth.id != user_id",
    "name": "posts"
  }, collection)

  return app.save(collection)
})
