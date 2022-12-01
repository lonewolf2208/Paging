package com.example.clearcals.model

data class Result(
    val approved_at: Int,
    val aspect_ratio: String,
    val beauty_url: String,
    val brand: Brand,
    val brand_id: Int,
    val buzz_id: Any,
    val canonical_id: String,
    val compilations: List<Compilation>,
    val cook_time_minutes: Int,
    val country: String,
    val created_at: Int,
    val credits: List<Credit>,
    val description: String,
    val draft_status: String,
    val facebook_posts: List<Any>,
    val id: Int,
    val inspired_by_url: Any,
    val instructions: List<Instruction>,
    val is_one_top: Boolean,
    val is_shoppable: Boolean,
    val keywords: String,
    val language: String,
    val name: String,
    val num_servings: Int,
    val nutrition: Nutrition,
    val nutrition_visibility: String,
    val original_video_url: String,
    val prep_time_minutes: Int,
    val promotion: String,
    val renditions: List<Rendition>,
    val sections: List<Section>,
    val seo_title: String,
    val servings_noun_plural: String,
    val servings_noun_singular: String,
    val show: ShowX,
    val show_id: Int,
    val slug: String,
    val tags: List<Tag>,
    val thumbnail_alt_text: String,
    val thumbnail_url: String,
    val tips_and_ratings_enabled: Boolean,
    val topics: List<Topic>,
    val total_time_minutes: Int,
    val total_time_tier: TotalTimeTier,
    val updated_at: Int,
    val user_ratings: UserRatings,
    val video_ad_content: String,
    val video_id: Int,
    val video_url: String,
    val yields: String
)