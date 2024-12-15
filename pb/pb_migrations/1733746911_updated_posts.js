/// <reference path="../pb_data/types.d.ts" />
migrate((app) => {
  const collection = app.findCollectionByNameOrId("pbc_1125843985")

  // update collection data
  unmarshal({
    "listRule": "@request.auth.id = user_id",
    "viewRule": ""
  }, collection)

  return app.save(collection)
}, (app) => {
  const collection = app.findCollectionByNameOrId("pbc_1125843985")

  // update collection data
  unmarshal({
    "listRule": "",
    "viewRule": "@request.auth.id = user_id"
  }, collection)

  return app.save(collection)
})