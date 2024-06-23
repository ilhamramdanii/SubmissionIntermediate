package com.dicoding.submissionintermediate.ui.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair as UtilPair
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.submissionintermediate.data.remote.response.Story
import com.dicoding.submissionintermediate.databinding.ListStoryBinding


class StoryAdapter(private var stories: List<Story>) : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding = ListStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bind(stories[position])
    }

    override fun getItemCount(): Int = stories.size

    fun updateStories(newStories: List<Story>) {
        stories = newStories
        notifyDataSetChanged()
    }

    class StoryViewHolder(private val binding: ListStoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(story: Story) {
            Glide.with(binding.root.context)
                .load(story.photoUrl)
                .into(binding.ivPhotoDetail)
            binding.tvStoryName.text = story.name
            binding.tvDetailDescription.text = story.description

//            binding.root.setOnClickListener {
//                val context = binding.root.context
//                val intent = Intent(context, DetailStoryActivity::class.java).apply {
//                    putExtra(DetailStoryActivity.EXTRA_STORY, story)
//                }
//
//                val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
//                    context as Activity,
//                    UtilPair(binding.ivPhotoDetail, "profile"),
//                    UtilPair(binding.tvStoryName, "judul"),
//                    UtilPair(binding.tvDetailDescription, "description")
//                )
//
//                context.startActivity(intent, optionsCompat.toBundle())
//            }
        }
    }
}
